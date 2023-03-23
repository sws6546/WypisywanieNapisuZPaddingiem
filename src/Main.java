import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String napis = "Ala ma kota\nA kot ma alę";
        ArrayList<String> linie = stringToLines(napis);
        printLines(linie);
    }

    public static void printLines(ArrayList<String> linie){
        int max = getMaxLine(linie);
        print(linie, max);
    }

    public static void print(ArrayList<String> linie, int max){
        for(int i = 0; i < linie.size() + 4; i++){
            if(i == 0 || i == linie.size() + 3){
                String hashes = "";
                for(int j = 0; j < max + 4; j++){
                    hashes += "#";
                }
                System.out.println(hashes);
            }else if(i == 1 || i == linie.size() + 2){
                String hashes = "# ";
                for(int j = 0; j < max; j++){
                    hashes += " ";
                }
                hashes += " #";
                System.out.println(hashes);
            }else{
                String line = "# ";
                if(linie.get(i - 2).length() == max){
                    line += linie.get(i - 2) + " #";
                }else{
                    String spacje = "";
                    for(int j = 0; j < ( max - linie.get(i - 2).length() ); j++){
                        spacje += " ";
                    }
                    line += linie.get(i - 2) + spacje + " #";
                }
                System.out.println(line);
            }
        }
    }

    public static int getMaxLine(ArrayList<String> linie){
        int max = 0;
        for(int i = 0; i < linie.size(); i++){
            if(linie.get(i).length() > max){
                max = linie.get(i).length();
            }
        }
        return max;
    }

    public static ArrayList<String> stringToLines(String napis){
        ArrayList<String> linie = new ArrayList<>();
        String linia = "";
        for(int i = 0; i < napis.length(); i++){
            if(napis.charAt(i) == '\n'){
                linie.add(linia);
                linia = "";
            }else if(i == napis.length() - 1){
                linia += napis.charAt(i);
                linie.add(linia);
            }else{
                linia += napis.charAt(i);
            }
        }
        return linie;
    }
}