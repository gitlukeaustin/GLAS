package Main.Model;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.util.Vector;
import java.awt.geom.Line2D;

public class Son implements Runnable
{
	private final int BUFL = 128000;
	private File soundfile;
	private AudioInputStream stream;
	private AudioFormat format;
	private SourceDataLine source;

    	private FloatControl volume;
	private FloatControl reverb;
	private FloatControl gain;
	private FloatControl sample_rate;	
	private FloatControl echo;
	private FloatControl vitesse;
	private FloatControl pan;	

    private boolean play;
    private boolean stop;

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

	public Vector createWaveForm(Dimension d) {
		byte[] audioBytes = null;
		Vector lines = new Vector();
        lines.removeAllElements();  // clear the old vector

        //AudioFormat format = this.stream.getFormat();
        if (audioBytes == null) {
            try {
                audioBytes = new byte[
                    (int) (this.stream.getFrameLength() 
                    * this.format.getFrameSize())];
                this.stream.read(audioBytes);
            } catch (Exception ex) { 
                ex.printStackTrace();
                return null; 
            }
        }

        //Dimension d = getSize();
        int w = d.width;
        int h = d.height-15;
        int[] audioData = null;
        int nb16=0,nb8=0;
        if (format.getSampleSizeInBits() == 16) {
             int nlengthInSamples = audioBytes.length / 2;
             System.out.println("length="+nlengthInSamples);
             audioData = new int[nlengthInSamples];
             if (format.isBigEndian()) {
                for (int i = 0; i < nlengthInSamples; i++) {
                     /* First byte is MSB (high order) */
                     int MSB = (int) audioBytes[2*i];
                     /* Second byte is LSB (low order) */
                     int LSB = (int) audioBytes[2*i+1];
                     audioData[i] = MSB << 8 | (255 & LSB);
                     nb16++;
                 }
             } else {
                 for (int i = 0; i < nlengthInSamples; i++) {
                     /* First byte is LSB (low order) */
                     int LSB = (int) audioBytes[2*i];
                     /* Second byte is MSB (high order) */
                     int MSB = (int) audioBytes[2*i+1];
                     audioData[i] = MSB << 8 | (255 & LSB);
                     nb16++;
                 }
             }
         } else if (format.getSampleSizeInBits() == 8) {
             int nlengthInSamples = audioBytes.length;
             audioData = new int[nlengthInSamples];
             System.out.println("length="+nlengthInSamples);
             if (format.getEncoding().toString().startsWith("PCM_SIGN")) {
                 for (int i = 0; i < audioBytes.length; i++) {
                     audioData[i] = audioBytes[i];
                     nb8++;
                 }
             } else {
                 for (int i = 0; i < audioBytes.length; i++) {
                     audioData[i] = audioBytes[i] - 128;
                     nb8++;
                 }
             }
        }else if (format.getSampleSizeInBits() == 24) {
             int nlengthInSamples = audioBytes.length / 3;
             System.out.println("length="+nlengthInSamples);
             audioData = new int[nlengthInSamples];
             if (format.isBigEndian()) {
                for (int i = 0; i < nlengthInSamples; i++) {
                     /* First byte is MSB (high order) */
                     int MSB = (int) audioBytes[2*i];
                     /* Second byte is LSB (low order) */
                     int LSB = (int) audioBytes[2*i+1];
                     audioData[i] = MSB << 8 | (255 & LSB);
                     nb16++;
                 }
             } else {
                 for (int i = 0; i < nlengthInSamples; i++) {
                     /* First byte is LSB (low order) */
                     int LSB = (int) audioBytes[2*i];
                     /* Second byte is MSB (high order) */
                     int MSB = (int) audioBytes[2*i+1];
                     audioData[i] = MSB << 8 | (255 & LSB);
                     nb16++;
                 }
             }
         }
           
        int frames_per_pixel = audioBytes.length / format.getFrameSize()/w;
        byte my_byte = 0;
        double y_last = 0;
        int nbLine=0;
        int numChannels = format.getChannels();
        for (double x = 0; x < w && audioData != null; x++) {
            int idx = (int) (frames_per_pixel * numChannels * x);
            if (format.getSampleSizeInBits() == 8) {
                 my_byte = (byte) audioData[idx];
            } else if(format.getSampleSizeInBits() == 16){
                 my_byte = (byte) (128 * audioData[idx] / 32768 );
            }
            else
            {
            	 my_byte = (byte) (128 * audioData[idx] / (32768*2) );
            }
            double y_new = (double) (h * (128 - my_byte) / 256);
            nbLine++;
            lines.add(new Line2D.Double(x, y_last, x, y_new));
            y_last = y_new;
        }
        System.out.println("nombre ligne = "+nbLine+" nb16="+nb16+" nb8="+nb8+" sampleSizeinBits="+format.getSampleSizeInBits());
        return lines;
    }
	public void run() /* jouerson */
	{
        this.play = true;
        this.stop = false;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		
		try
		{
            		if(this.source != null)
            		{
               			 this.source.close();
            		}
			this.source = (SourceDataLine) AudioSystem.getLine(info);
			this.volume = (FloatControl) source.getControl(FloatControl.Type.VOLUME);

			this.volume = (FloatControl) source.getControl(FloatControl.Type.VOLUME);
			this.reverb = (FloatControl) source.getControl(FloatControl.Type.REVERB_SEND);
			this.sample_rate = (FloatControl) source.getControl(FloatControl.Type.SAMPLE_RATE);
			this.pan = (FloatControl) source.getControl(FloatControl.Type.PAN);
			this.gain = (FloatControl) source.getControl(FloatControl.Type.MASTER_GAIN);
			this.echo = (FloatControl) source.getControl(FloatControl.Type.REVERB_RETURN);
			this.source.open(format);
			
		}
		catch(LineUnavailableException e)
		{
			System.out.println("Line unavailable");
		}

		this.source.start();

		int bytes = 0;

		byte[] buf = new byte[BUFL];
		while(bytes != -1 && this.play)
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
				int byteswritten = this.source.write(buf, 0, bytes);
			}
		}
	
        if(stop)
        {
            this.source.drain();
        }
        
	}
    
    public void arreterSon()
    {
        this.play = false;
        this.stop = true;
    }
    
    public void pauseSon()
    {
        this.play = false;
        this.stop = false;
    }


	public void changerEffet(String nom, int valeur)
	{
		if(nom.equals("Volume"))
		{
			this.volume.setValue((float)valeur);
			System.out.println("Changement du volume");
		}
		else if(nom.equals("Echo"))
		{
			this.echo.setValue((float)valeur);
			System.out.println("Changement de l'echo");
		}
		else if(nom.equals("Compression"))
		{
			this.sample_rate.setValue((float)valeur);
			System.out.println("Changement du compression");
		}
		else if(nom.equals("Vitesse"))
		{
			this.vitesse.setValue((float)valeur);
			System.out.println("Changement du vitesse");
		}	
		else if(nom.equals("Reverb"))
		{
			this.reverb.setValue((float)valeur);
			System.out.println("Changement du reverb");
		}
	}

}
