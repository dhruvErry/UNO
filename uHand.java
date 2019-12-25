import java.util.ArrayList;
import java.util.List;
class uHand
{
  private List<uCard> hand=new ArrayList<>();
  uDec d;
  int a;
  Main m;
  uHand(){
    if(m.comp)
        d=Comp.d;
    else    
        d=noComp.d;
    a=0;
    while(a<7){
      hand.add(d.deal());
      a++;
    }
  }
  void print(){
    a=0;
    for(uCard u:hand){
      System.out.println((a+1)+") "+u.printCard());
      a++;
    }
    System.out.println();
  }
  uCard removeCard(int n){
    return hand.remove(n);
  }
  uCard deel(){
    return d.deal();
  }
  void addCard(){
    hand.add(d.deal());
  }
  void addCard(uCard f){
    hand.add(f);
  }
  int getSize(){
    return hand.size();
  }
  boolean sameCard(uCard a, int b, char c, char d){
    if(b!=-1){
      if(a.getRank()!=b)
      return false;
    }
    else if(c!=' '){
      if(a.getCol()!=c)
      return false;
    }
    else if(d!=' '){
      if(a.getCol()!=d)
      return false;
    }
    return true;
  }
  int checCard(int a, char b, char c){
    int u=0;
    while(u<hand.size()){
      if(sameCard(hand.get(u), a, b, c))
      return u;
      u++;
    }
    return -1;
  }
}
