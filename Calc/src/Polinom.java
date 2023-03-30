import java.util.ArrayList;

public class Polinom {
    ArrayList<Element> polinomList = new ArrayList<>();
    private int level;

    void printBlank(int n){
        int i;
        for (i=0;i<n;i++) System.out.print(" ");
    }
 int transfer(char polinChar[],int startPolinom,int endPolinom,int level){
     this.level=level;
    if (endPolinom>=1) {
        for (; startPolinom < endPolinom; ) {
            Element newElement = new Element();
            startPolinom = newElement.getElement(polinChar, startPolinom,  level);
//            System.out.println(newElement.polinElement.toString().toUpperCase());
//            String str=newElement.polinElement.toString().toUpperCase();
//            if(str=="END"){
//                System.out.println( newElement.polinElement.toString().toUpperCase() );
//                return -1;
//            }
            if(newElement.type!='b' & newElement.type !='(' & newElement.type !=')'){ polinomList.add(newElement);}
            else if(newElement.type =='(' ){
//                        System.out.println(newElement.type);
                        Polinom subPolinom = new Polinom();
                        startPolinom = subPolinom.transfer(polinChar,startPolinom,endPolinom,level+1);
//                        if (startPolinom==-1) return -1;
                        if(subPolinom.polinomList.get(0).type=='d'){
                            newElement.a=subPolinom.polinomList.get(0).a;
                            newElement.type='d';
                            polinomList.add(newElement);
//                            System.out.println("Субполином посчитали -  " + newElement.a);
                        }else{
                            System.out.println("Во вложеном полиноме сбой");
                            newElement.a=subPolinom.polinomList.get(0).a;
                            newElement.type='u';
                            polinomList.add(newElement);
                        }

            }else if(newElement.type==')'){  break;}
//            printBlank(level);
//            System.out.println("New - " + newElement.polinElement);
        }
    }
    // это пока для диагностики печать
//    int ii;
//    printBlank(level);
//    System.out.println(level);
//    for (ii=0;ii<polinomList.size();ii+=1){
//        printBlank(level);
//        System.out.println("Kod - "+polinomList.get(ii).kod+"Element - " + polinomList.get(ii).polinElement + "  Type - " + polinomList.get(ii).type +" Operation - "+polinomList.get(ii).op);
//    }
//    System.out.println("расчет будет");
     if(calcPolinom()){
         printBlank(level);
         System.out.println("Ответ - " + polinomList.get(0).a);
     } else{
         System.out.println("В полиноме сбой");
         polinomList.get(0).type='u';
     }
     return startPolinom;
    };

    boolean calcPolinom(){
        int i;
        // function made
//        System.out.println("Расчет начался");
        if(polinomList.size()==1) return true;
            for (i = 0; i < polinomList.size(); i++) {
                if (polinomList.get(i).type == 'f') {
//                    if (polinomList.get(i).polinElement.toString().toUpperCase()=="END"){
//                        polinomList.get(0).polinElement=polinomList.get(i).polinElement;
//                        return false;
//                    }
                    if (i == (polinomList.size() - 1)) {
                        System.out.println("No argument function - " + polinomList.get(i).polinElement);
                        return false;
                    } else if (polinomList.get(i + 1).type != 'd') {
                        System.out.println("No argument function - " + polinomList.get(i).polinElement);
                        return false;
                    } else if (polinomList.get(i + 1).type == 'd') {
                        // пока все функции этоо *1000 потом сюда switch поставить
                        polinomList.remove(i);
                        polinomList.get(i).a *= 1000;
                    }
                }
            }
            //поиск унитарных - и + в первой позиции
            if (polinomList.get(0).type == 'z' & polinomList.get(1).type == 'd') {
                if (polinomList.get(0).op == 45) {
                    polinomList.get(1).a *= -1;
                    polinomList.remove(0);
                } else if (polinomList.get(0).op == 43) {
                    polinomList.remove(0);
                }
            }
            //поиск самых приоритетных действий - это сейчас **
            for (i = 1; i < (polinomList.size()-2); i++) {
//                System.out.println("** Satrt");
                if(polinomList.get(i).type=='z' & polinomList.get(i).op==42 & polinomList.get(i+1).op==42){
                    if (polinomList.get(i+2).type!='d'){
                        System.out.println("No argument 2 - ** ");
                        return false;
                    } else if (polinomList.get(i-1).type!='d') {
                        System.out.println("No argument 1 - ** ");
                        return false;
                    }else {
                        polinomList.get(i-1).a=(int)Math.pow((double)polinomList.get(i-1).a,(double) polinomList.get(i+2).a);
                        polinomList.remove(i);polinomList.remove(i);polinomList.remove(i);
                    }
                }
            }//поиск приоритетных действий - это сейчас * & /
            for (i = 1; i < (polinomList.size()-1); i++) {
//                System.out.println("* or / Satrt");
                if(polinomList.get(i).type=='z' & (polinomList.get(i).op==42 | polinomList.get(i).op==47)){
                    if (polinomList.get(i+1).type!='d'){
                        System.out.println("No argument 2 - * or / ");
                        return false;
                    } else if (polinomList.get(i-1).type!='d') {
                        System.out.println("No argument 1 - * or /");
                        return false;
                    }else {
                        if (polinomList.get(i).op==42) {
                            polinomList.get(i - 1).a = (int) polinomList.get(i - 1).a * polinomList.get(i + 1).a;
                        }else {
                            polinomList.get(i - 1).a = (int) polinomList.get(i - 1).a / polinomList.get(i + 1).a;
                        }
                        polinomList.remove(i);polinomList.remove(i);
                        i--;
                    }
                }
            }
         // + и -
            int flag=1;
            while(flag!=0) {
                flag=0;
//                System.out.println("Начали + -");
//                System.out.println(" "+ polinomList.size());
                for (i = 1; i < polinomList.size(); i++) {
                    if (polinomList.get(i).type == 'd' & polinomList.get(i - 1).type == 'z' & (polinomList.get(i-1).op==43 | polinomList.get(i-1).op==45 )) {
                        if (polinomList.get(i-1).op == 45) polinomList.get(i).a *= -1;
                        polinomList.remove(i-1);
                        flag+=1;
                    }
                }
            }
            for (i = 0; i < (polinomList.size()-1);) {
                if(polinomList.get(i).type!='d' & polinomList.get(i+1).type!='d'){
                    System.out.println("Не правильое выражение ");
                    return false;
                }
                polinomList.get(i).a+=polinomList.get(i+1).a;
                polinomList.remove(i+1);
            }
        return true;
    }

}

