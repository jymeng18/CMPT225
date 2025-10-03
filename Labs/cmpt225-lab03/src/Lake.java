public class Lake implements Comparable<Lake>{
    String name;
    int area; // in km^2
    public Lake(String name, int area){
        this.name = name;
        this.area = area;
    }

    @Override
    public int compareTo(Lake o){
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString(){
        return this.name+":"+this.area;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Lake){
            return this.area == ((Lake)obj).area;
        }
        return false;
    }
}
