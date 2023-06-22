public class findeElem<m extends Comparable>{
    int indexStart;
    int indexEnd;
    m[] mas;
    m el;

    public int find(m[] mas, m el){
        int lenght=mas.length;
        this.mas=mas;
        this.el=el;
        indexEnd=lenght-1;
        indexStart=0;
        if (mas==null) throw new NullPointerException("Massiv --Null");
        if (lenght==1) return 0;
        if (lenght==2) if(mas[indexStart].compareTo(el)==0){return indexStart;} else
                                if (mas[indexEnd].compareTo(el)==0) {
                                        return indexEnd;
                                }else return -1;
        return findInPodMass();
    }

    public int findInPodMass(){
        System.out.println("start " + indexStart+" end "+indexEnd);
        int mid;
        int comp;
        if(indexEnd-indexStart==1){
            if(mas[indexStart].compareTo(el)==0){return indexStart;} else
            if (mas[indexEnd].compareTo(el)==0) {
                return indexEnd;
            }else return -1;
        }
        mid=(indexEnd+indexStart)/2;
        if ((comp=mas[mid].compareTo(el))>0){
            indexEnd=mid-1;
            return findInPodMass();
        } else if (comp==0) {
            return mid;
        } else{
            indexStart=mid+1;
            return findInPodMass();
        }
    }

}
