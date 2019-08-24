public class uPlayer
{
    private uHand h;
    private String name;
    private int hSize;
    public uPlayer(String name){
        h=new uHand();
        this.name=name;
    }
    uCard playCard(int n){
        return h.removeCard(n);
    }
    void add(){
        h.addCard();
    }
    int hSize(){
        return h.getSize();
    }
    String getName(){
        return name;
    }
    boolean lose(){
        if(hSize<1)
            return true;
        return false;
    }
    void add(uCard g){
        h.addCard(g);
    }
    void printHand(){
        h.print();
    }
    int check(int a, char b, char c){
        return h.checCard(a, b, c);
    }
}
