public class uCard
{
    private int rank;
    private char col;
    private char pow;
    public uCard(int rank, char col, char pow){
        this.rank=rank;
        this.col=col;
        this.pow=pow;
    }
    public int getRank(){
        return rank;
    }
    public char getCol(){
        return col;
    }
    public char getPow(){
        return pow;
    }
    public String toString(){
        String c="";
        if(rank>-1)
            c+="NUMBER: "+rank+"\n";
        String p="";
        if(col=='r')
            p="Red";
        if(col=='g')
            p="Green";
        if(col=='b')
            p="Blue";
        if(col=='y')
            p="Yellow";
        c+="COLOUR: "+p+"\n";
        if(col==' '){  
            if(pow=='w')
                c="POWER: Wild\n";
            if(pow=='D')
                c="POWER: Draw Four\n";
        }
        if(pow=='d')
            c+="POWER: Draw Two\n";
        if(pow=='r')
            c+="POWER: Reverse\n";
        if(pow=='s')
            c+="POWER: Skip\n";
        return c;
    }
}
    