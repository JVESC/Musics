import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class Sick_Love{
    static Player player;
    public static void playMusic(String arquivo, int segundos) {
    try {
        FileInputStream fis = new FileInputStream(arquivo);
        fis.skip((long)(segundos * 128 * 1024 / 8));
        player = new Player(fis);
        new Thread(() -> {
            try {
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void clear() {
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public class Cores{
         static final String Reset= "\u001B[0m";
         static final String Vermelho = "\u001B[31m";
         static final String Laranja ="\u001B[38;5;208m";
         static final String Roxo = "\u001B[35m";
         static final String Cinza = "\u001B[1m";

    }
    public static void White(String texto, int velo, boolean pula){
        for(char letra : texto.toCharArray()){
            System.out.print(letra);
            try {
                Thread.sleep(velo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if(pula)System.out.println();

    }

    public static void main(String[] args) throws InterruptedException {
        clear();
        playMusic("Sick Love.mp3", 181); // 14 = segundo que quer começar
        White(Cores.Vermelho +"I don't know, but it's been said", 70,true);
        Thread.sleep(1100);
        White("Your heart is stronger than your head", 61,true);
        Thread.sleep(1000);
        White("And this location is my home"+Cores.Vermelho, 95,true);
        Thread.sleep(2000);
        System.out.println();
        White(Cores.Laranja+"Rivers get connected", 70,true);
        Thread.sleep(1000);
        White("So much stronger than expected, well", 86,true);
         Thread.sleep(450);
        White("Sick love", 90, false);
        White(" comes to wash us away", 65,true);
         Thread.sleep(4500);
        White(Cores.Roxo +"Prisons of perspective"+Cores.Laranja, 45,true);
         Thread.sleep(1200);
        White("How your vision gets corrected and", 80,true);
         Thread.sleep(1000);
        White("Sick love", 90, false);        
        White(" is my modern cliché", 65,true);
        System.out.println(Cores.Reset);
        player.close();
        System.exit(0);
    }
}