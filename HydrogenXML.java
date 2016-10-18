/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hydrogenxml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Степан
 */
public class HydrogenXML
{

    private static final String names[] =
    {/*
        "SMM_KICK_K68_V01",
        "sd14x08tama-mp-tsn-rm",
        "SNR_1965_V01_NR_MULTI",
        "SNR_1965_V01_SR_MULTI",
        "loTom_OH_PP",
        "loTom_OH_MP",
        "loTom_OH_FF",
        "SMM_TOM369_V01",
        "SMM_TOM269_V01",
        "hiTom_OH_P",
        "hiTom_OH_F",
        "hiTom_OH_FF",
        "SMM_RIDE17_BELL_V01",
        "SMM_RIDE17_MAIN_V01",
        "SMM_RIDE20_BELL_V01",
        "SMM_RIDE20_MAIN_V01",
        "SMM_CRASH15_V01",
        "SMM_CRASH17_V01",
        "SMM_HAT14_CLH_V01",
        "SMM_HAT14_LSH_V01",
        "SMM_HAT14_OPH_V01",
        "SMM_HAT14_FCH_V01",
        "splash1_OH_F",
        "splash1_OH_P",*/
        "hihatClosed_OH_F",
        "hihatClosed_OH_P",
        "hihatFoot_OH_MP",
        "hihatFootStomp_OH_MP",
        "hihatOpen_OH_F",
        "hihatOpen_OH_FF",
        "hihatOpen_OH_P",
        "hihatSemiOpen1_OH_F",
        "hihatSemiOpen1_OH_P",
        "hihatSemiOpen2_OH_F",
        "hihatSemiOpen2_OH_P",
        "hihatSemiOpen3_OH_F",
        "hihatSemiOpen3_OH_P",
        "hihatSemiOpen4_OH_F",
        "hihatSemiOpen4_OH_P",
        "hihatSemiOpen5_OH_F",
        "hihatSemiOpen5_OH_P",
        "hihatSemiOpen6_OH_F",
        "hihatSemiOpen6_OH_P",
        "hihatSemiOpen7_OH_F",
        "hihatSemiOpen7_OH_P",        
        "cowbell_FF", 
        "cowbell_MP",
        "cowbell_P"
    };
    private static final int counts[] =
    {/*
        127, 16, 127, 127, 6, 10, 8, 49, 49, 9, 10, 12, 49, 49, 45, 45, 45, 45, 127, 127, 26, 92, 5, 5*/
        20, 20, 12, 4, 5, 6, 7, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 9, 9, 11
        
    };
    private static final int rr[] =
    {/*
        1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1*/
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
    };
    
    private static final int tp[] =
    {/*
        1, 3, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 2, 2*/
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2
    };

    private static final String pathFrom = "J:\\AudioSamples\\SM MegaReaper Drumkit\\samples\\cleaned\\";
    private static final String pathTo = "J:\\AudioSamples\\SM MegaReaper Drumkit\\samples\\to\\";

    public static void copy(File source, File dest) throws IOException
    {
//        System.out.println("Copy file '" + source.getPath() + "' to '" + dest.getPath() + "'");
//        Files.copy(source.toPath(), dest.toPath());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < names.length; k++)
        {
            for (int t = 1; t <= rr[k]; t++)
            {
                double j = 0.0;
                int count = counts[k];
                String filename = names[k];

                if (tp[k] == 1)
                    filename += "_VEL";
                if (tp[k] == 2)
                    filename += "_";
                if (tp[k] == 3)
                    filename += "-v";
                if (tp[k] == 4)
                    filename += "_PUBLIC_";

                String rand = String.format("%02d", t);
                sb = sb.append("\t<instrument>\n");
                sb = sb.append("\t\t<id>").append(counter).append("</id>\n");
                sb = sb.append("\t\t<name>").append(names[k]);
                
                if (tp[k] == 1 && rr[k] >= 1)
                {
                    sb = sb.append("_R").append(rand);
                }
                
                sb = sb.append("</name>\n");
                sb = sb.append("\t\t<volume>1</volume>\n");
                sb = sb.append("\t\t<isMuted>false</isMuted>\n");
                sb = sb.append("\t\t<pan_L>1</pan_L>\n");
                sb = sb.append("\t\t<pan_R>1</pan_R>\n");
                sb = sb.append("\t\t<randomPitchFactor>0</randomPitchFactor>\n");
                sb = sb.append("\t\t<gain>1</gain>\n");
                sb = sb.append("\t\t<filterActive>false</filterActive>\n");
                sb = sb.append("\t\t<filterCutoff>1</filterCutoff>\n");
                sb = sb.append("\t\t<filterResonance>0</filterResonance>\n");
                sb = sb.append("\t\t<Attack>0</Attack>\n");
                sb = sb.append("\t\t<Decay>0</Decay>\n");
                sb = sb.append("\t\t<Sustain>1</Sustain>\n");
                sb = sb.append("\t\t<Release>1000</Release>\n");
                sb = sb.append("\t\t<muteGroup>-1</muteGroup>\n");
                sb = sb.append("\t\t<isStopNote>false</isStopNote>\n");
                sb = sb.append("\t\t<midiOutChannel>-1</midiOutChannel>\n");
                sb = sb.append("\t\t<midiOutNote>60</midiOutNote>\n");
                
                int fmax = 16;
                if (count < 16)
                    fmax = count;
                
                for (int i = 1; i <= fmax; i++)
                {
                    double k1 = (double) i / fmax;
                    
                    sb = sb.append("\t\t<layer>\n");
                    sb = sb.append("\t\t\t<filename>").append(filename);
                    if (tp[k]==1)
                        sb = sb.append(String.format("%03d", i * count / fmax)).append("_RR").append(rand);
                    else
                        sb = sb.append(String.format("%01d", i * count / fmax));
                    sb = sb.append(".wav</filename>\n");
                    sb = sb.append("\t\t\t<min>").append(String.format(Locale.US, "%.3f", j)).append("</min>\n");
                    sb = sb.append("\t\t\t<max>").append(String.format(Locale.US, "%.3f", k1)).append("</max>\n");
                    sb = sb.append("\t\t\t<gain>1</gain>\n");
                    sb = sb.append("\t\t\t<pitch>0</pitch>\n");
                    sb = sb.append("\t\t</layer>\n");
                    j = k1;
                    
                    File fileFrom, fileTo;
                    if (tp[k]==1)
                    {
                        fileFrom = new File(pathFrom + filename + String.format("%03d", i * count / fmax) + "_RR" + rand + ".wav");
                        fileTo = new File(pathTo + filename + String.format("%03d", i * count / fmax) + "_RR" + rand + ".wav");
                    }
                    else
                    {
                        fileFrom = new File(pathFrom + filename + String.format("%01d", i * count / fmax) + ".wav");
                        fileTo = new File(pathTo + filename + String.format("%01d", i * count / fmax) + ".wav");
                    }

                    if (fileFrom.exists())
                    {
                    try
                    {
                        copy(fileFrom, fileTo);
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(HydrogenXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    else
                    {
//                        System.out.println(fileFrom.getPath() + " -- Not Found!");
                    }
                }
                sb = sb.append("\t</instrument>\n");
                counter++;
            }
        }
        
        System.out.println(sb.toString());
    }
}
