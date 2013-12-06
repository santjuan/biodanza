package biodanza.modelo;

import java.io.FileInputStream;
import java.util.Map;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javazoom.jl.player.Player;

public class MusicPlayer implements Runnable
{
    private transient volatile boolean playing = false;
    private transient volatile Thread playingSong = new Thread(this);
    private transient volatile boolean paused = false;
    public transient volatile long duration;
    public transient volatile int currentFrame = 0;
    public transient volatile int frames = 0;
    public transient volatile boolean termino = false;
    private final transient Cancion song;
    private final transient Runnable finish;
    public static volatile MusicPlayer currentPlayer = null;

    private MusicPlayer(Cancion pSong, Runnable f)
    {
        song = pSong;
        finish = f;
    }

    public static synchronized MusicPlayer playSong(Cancion pSong, Runnable finish)
    {
        stopPlayer();
        return currentPlayer = new MusicPlayer(pSong, finish);
    }

    public static synchronized void stopPlayer()
    {
        if(currentPlayer != null)
        {
            currentPlayer.stop();
            currentPlayer = null;
        }
    }

    public void play()
    {
        if(isPaused())
        {
            synchronized(song)
            {
                paused = false;
                song.notifyAll();
            }
        }
        else
        {
            if(playingSong != null)
                stop();
            playingSong = new Thread(this);
            playing = true;
            playingSong.start();
        }
    }

    public void stop()
    {
        synchronized(song)
        {
            playing = false;
            paused = false;
            song.notifyAll();
            playingSong = null;
        }
    }

    public void pause()
    {
        paused = true;
    }

    public void run()
    {
        FileInputStream fIn = null;
        try
        {
            AudioFileFormat baseFileFormat = AudioSystem.getAudioFileFormat(song.getFile());
            Map<String, Object> properties = baseFileFormat.properties();
            Long d = (Long) properties.get("duration");
            if(d != null)
                duration = d;
            Integer f = (Integer) properties.get("mp3.length.frames");
            if(f != null)
                frames = f;
            currentFrame = 0;
            termino = false;
            fIn = new FileInputStream(song.getFile());
            Player p = new Player(fIn);
            while(isPlaying() && p.play(10))
            {
                currentFrame += 10;
                finish.run();
                synchronized(song)
                {
                    while(paused)
                        song.wait();
                }
            }
            if(isPlaying())
            {
                termino = true;
                stop();
                finish.run();
            }
            fIn.close();
            p.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public boolean isPlaying()
    {
        synchronized(song)
        {
            return playing;
        }
    }

    public boolean isPaused()
    {
        synchronized(song)
        {
            return paused;
        }
    }

    public Cancion currentSong()
    {
        synchronized(song)
        {
            return song;
        }
    }
}