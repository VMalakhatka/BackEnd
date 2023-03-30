public class Element {
    int kod;
    StringBuffer polinElement = new StringBuffer(); //елемент полинома
    int a; // если цыфра значение в int
    int op=0; // если это операция - то код ее *-42 +-43 - - 45 /-47 **-84 ++-86 -- - 90 //-94
    char type; // d-число z - знак арифметический(* + - / ** ++ -- //) f - фуннкция

//    Element(int a, int b, char op){
//        this.a=a ; this.b=b; this.op=op;
//    }


    public int getElement(char[] polinomChar, int i , int level) {
        kod=level*10000+i;
        Character ch = new Character(polinomChar[i]);
//            case 1 .. 5: case 'a' .. 'z':{
        if (ch.isAlphabetic(ch)) {
            type = 'f';
            for (; i < polinomChar.length; ) {
                // System.out.println(polinomChar[i]);
                polinElement.append(polinomChar[i]);
                i += 1;
                if (i == polinomChar.length) {
                    return i;
                } else {
                    ch = polinomChar[i];
                    if (!ch.isAlphabetic(ch)) {
                        return i;
                    }
                }
            }
        } else if (ch.isDigit(ch)) {
//            case '0'..'9'
            type = 'd';

            for (; i < polinomChar.length; ) {
                // System.out.println(polinomChar[i]);
                polinElement.append(polinomChar[i]);
                i += 1;
                a=Integer.parseInt(polinElement.toString());
                if (i == polinomChar.length) {
                    return i;
                } else {
                    ch = polinomChar[i];
                    if (!ch.isDigit(ch)) {
                        return i;
                    }
                }
            }

        } else if (ch == '+' | ch == '-' | ch == '*' | ch == '/') {
            type = 'z';
               op+=(int)ch;
            polinElement.append(ch);
                i += 1;
                        return i;
        }else if (ch.isWhitespace(ch)) {
            type='b';
            // пропускаем пробелы
            for (; i < polinomChar.length; ) {
                i += 1;
                if (i == polinomChar.length) {
                    return i;
                } else {
                    ch = polinomChar[i];
                    if (!ch.isWhitespace(ch)) {
                        return i;
                    }
                }
            }
        }else if (ch=='(' | ch==')') {
            type=ch;
                return ++i;
        }
        type = 'u';
        return i + 1;
    }
}

