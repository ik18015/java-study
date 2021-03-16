import java.io.*;

public class Twitter {
    public static void main(String[] args){


        for (
                int i = 0; // ①
                i < args.length; // ②
                i++ // ④ → ②に戻る
        ){
            System.out.println(args[i]); // ③
        }


        // ↓ 何か書く
        int i = 0; // ①
        //     ↓ 何か書く
        while (i < args.length ) { // ②
            // ↓ 何か書く
            System.out.println(args[i]); // ③
            System.out.println(args[i]);
            i++; // ④
        }

        register("ishikawa"); //ishikawaは登録されています
        register("ohyama"); //は登録されています
        register("satake"); //は登録されています
        register("aho"); //ahoを登録しました
    }

    private static void register() {
        // users.txt というファイルがある
        // 1行に1人のユーザの名前が書いてある
        String username = "ishikawa";

        // 同じユーザ名では登録できない（二重登録はだめ）

        // users.txt を読み込む （既に登録されているユーザ名の情報を読み込む）
        // 文字列型変数の配列を作って
        String[] users = new String[10];
        // 一人一人のユーザ名を入れる
        try {
            File file = new File("src\\users.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String str;
            int j = 0;
            while ((str = bufferedReader.readLine()) != null) {
                // usersの各要素にstrを順に代入する
                // System.out.println(str);
                users[j] = str;
                j++;
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            System.out.println(e);
        } catch(IOException e) {
            System.out.println(e);
        }






        // 文字列変数の配列に「登録しようとしている人のユーザ名」があったら（二重登録なので）
        // 既に登録済だと出力する
        // 終了

        // なければ登録する
        // users.txt にユーザ名を追加する
        // 終了
    }

    private static void tweet(String username ,String message){
        try{
            File file = new File("src\\tweet.txt");

            if (checkBeforeWritefile(file)){
                FileWriter filewriter = new FileWriter(file, true);

                filewriter.write("\n" + "username:");
                filewriter.write(username);
                filewriter.write(" message:");
                filewriter.write(message);
                //username:実際の名前 message:書き込んだもの
                filewriter.close();
            }else{
                System.out.println("ファイルに書き込めません");
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }

    private static boolean checkBeforeWritefile(File file){
        if (file.exists()){
            if (file.isFile() && file.canWrite()){
                return true;
            }
        }

        return false;
    }
}







