package es.datastructur.synthesizer;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    private final static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public GuitarString[] guitarString;
    GuitarHero () {
        guitarString = new GuitarString[keyboard.length()];
        for (int i=0; i < keyboard.length();i++) {
            guitarString[i] = new GuitarString(440*Math.pow(2,(i-24)/12));
        }
    }
    public static void main(String[] args) {
        GuitarHero gh = new GuitarHero();
        while (true) {
            if(StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                System.out.print(key);
                int keyIdx = keyboard.indexOf(key);
                if(keyIdx == -1) {
                    continue;
                }
                gh.guitarString[keyIdx].pluck();
                for (int i = 0; i < 50000; i += 1) {
                    StdAudio.play(gh.guitarString[keyIdx].sample());
                    gh.guitarString[keyIdx].tic();
                }
            }
        }
    }

}
