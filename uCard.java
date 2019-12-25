class uCard
{
  private int rank;
  private char col;
  private char pow;
  uCard(int rank, char col, char pow){
    this.rank=rank;
    this.col=col;
    this.pow=pow;
  }
  int getRank(){
    return rank;
  }
  char getCol(){
    return col;
  }
  char getPow(){
    return pow;
  }
  String printCard(){
    String c="";
    if(rank>-1)
    c+="NUMBER: "+rank+"         ";
    if(col==' '){
      if(pow=='w')
      c="POWER: Wild ";
      if(pow=='D')
      c="POWER: Draw Four ";
    }
    if(pow=='d')
    c+="POWER: Draw Two   ";
    if(pow=='r')
    c+="POWER: Reverse    ";
    if(pow=='s')
    c+="POWER: Skip       ";
    String p="";
    if(col=='r')
    p="Red";
    if(col=='g')
    p="Green";
    if(col=='b')
    p="Blue";
    if(col=='y')
    p="Yellow";
    if(col!=' ')
    c+="COLOUR: "+p+" ";
    return c;
  }
}
