package Main.Model;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Son
{
	private final int BUFL = 128000;
	private File soundfile;
	private AudioInputStream stream;
	private AudioFormat format;
	private SourceDataLine source;

	public Son(File f)
	{
		soundfile = f;
		try
		{
			stream = AudioSystem.getAudioInputStream(soundfile);
			format = stream.getFormat();	
		}
		catch(Exception e)
		{
			System.out.println("Ce type de fichier n'est pas supporté.");
		}
	}


	public void jouerSon()
	{
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try
		{
			source = (SourceDataLine) AudioSystem.getLine(info);
			source.open(format);
			
		}
		catch(LineUnavailableException e)
		{
			System.out.println("Line unavailable");
		}

		source.start();

		int bytes = 0;

		byte[] buf = new byte[BUFL];
		while(bytes != -1)
		{	
			try
			{
				bytes = stream.read(buf, 0, buf.length);
			}
			catch(IOException e)
			{
				System.out.println("Problème de lecture!");
			}
			if(bytes >= 0)
			{
				int byteswritten = source.write(buf, 0, bytes);
			}
		}
	
		source.drain();
		source.close();
	}

}
