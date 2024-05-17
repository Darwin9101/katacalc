import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class calc {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //сканер
        System.out.println("Калькулятор\nВведите через пробел числа и знак, пример: \"3 + 2\"");
        //засунул в бесконечный цикл для более простой проверки
        while (true) {
            String str = sc.nextLine(); //сканим некстлайн помещает в str
            String[] str_cut = str.split(" ");//разделяем полученную строку на части, где под индексами 0- первое число 1- второе, 2-второе число
            if (str_cut.length != 3) { //если введено более/менее 3х разных строк (2 +, 2, 2+3+5...)
                throw new IOException();
            }
            //int a=calc(str_cut); //работа с калькулятором
            if (Objects.equals(calc(str_cut), "-999")) {
                throw new IOException();
            } else {
                System.out.println(calc(str_cut));
            }
        }

    }
    public static String calc (String[] str) throws IOException {
        String[] str_rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] str_arab = {"1","2","3","4","5","6","7","8","9","10"};
        int num1=0;
        int num2=0;
        //проверяем первое число на соответствие римским числам
        for (int i = 0; i < str_rome.length; i++) {
            if (str[0].equals(str_rome[i])) {
                //если первое число соответсвует римскому числу, в интовую переменную1 кладем индекс+1 и проверяем второе число
                num1=i+1;
                for (int j = 0; j < str_arab.length; j++) {
                    //по аналогии с первым числом находим второе
                    if (str[2].equals(str_rome[j])) {
                        num2=j+1;
                        switch (str[1]){
                            case "+": num1+=num2; break;
                            case "-": num1-=num2; break;
                            case "*": num1*=num2; break;
                            case "/": num1/=num2; break;
                            default: throw new IOException(); //если знаки не подошли- ошибка
                        }
                        if (num1<=0) {
                            throw new IOException();
                        }
                        String result="";
//                        while (num1>10){
//                            num1-=10;
//                            result+="X";
//                        } сработало бы, если бы не порядок числа
                        switch  (num1/10)
                        {
                            case 1:result+="X";num1%=10; break;
                            case 2:result+="XX";num1%=10; break;
                            case 3:result+="XXX";num1%=10; break;
                            case 4:result+="XL";num1%=10; break;
                            case 5:result+="L";num1%=10; break;
                            case 6:result+="LX";num1%=10; break;
                            case 7:result+="LXX";num1%=10; break;
                            case 8:result+="LXXX";num1%=10; break;
                            case 9:result+="XC";num1%=10; break;
                            case 10:result+="C";num1%=10; break;
                        }
                        if (num1!=0) {
                            result+=str_rome[num1-1];
                        }
                        return result;
                    }
                }//если второе число не подошло- ошибка
                throw new IOException();
            }
        }
        for (int i = 0; i < str_arab.length; i++) {
            if (str[0].equals(str_arab[i])){
                num1=i+1;
                for (int j=0;j< str_arab.length;j++){
                    if (str[2].equals(str_arab[j])){
                        num2=j+1;
                        switch (str[1]){
                            case "+": num1+=num2; break;
                            case "-": num1-=num2; break;
                            case "*": num1*=num2; break;
                            case "/": num1/=num2; break;
                            default: throw new IOException();
                        }
                        return Integer.toString(num1);
                    }

                }
                throw new IOException();
            }
        }
        return "-999";
    }
}



