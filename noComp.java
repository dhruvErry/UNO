 import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class noComp {
    static Scanner yo=new Scanner(System.in);
    static List<uPlayer>players=new ArrayList<>();
    static uPlayer p;
    static uHand h;
    static uDec d;
    static uCard first;
    static int a, r1, r, k;
    static char c1=' ';
    static char p1=' ';
    static char c=' ';
    static boolean rev;
    static void input(){
        d=new uDec();
        System.out.println("How many players will be playing?");
        int n=yo.nextInt();
        int a=1;
        while(a<=n){
            System.out.println("Enter Player "+a+"'s Name:");
            p=new uPlayer(yo.next());
            players.add(p);
            a++;
        }
    }

    static void fCard(){
        System.out.println("\nThe card on the Table is: ");
        first=d.dealFirst();
        while(first==null)
            first=d.dealFirst();
        System.out.println("\n"+first.printCard()+"\n");
    }

    static void play(){
        a=0;
        int u=0;
        int h=0;
        int m=0;
        rev=false;
        boolean further=false;
        boolean goOn=true;
        c=' ';
        while(a<players.size()){
            check();
            p=players.get(a);
            String d=p.getName();
            goOn=true;
            further=false;
            if(u==1)
                draw(p, 2);
            else if(u==2)
                draw(p, 4);
            if(u==3){
                p.printHand();
                System.out.println("Which card might you choose? If you are UNABLE to play, press 0.");
            }
            else {
                System.out.println("It's your turn, "+p.getName()+"!\n");
                p.printHand();
            }
                if(u==3){
                        h=yo.nextInt();
                        if(h==0){
                            nextPlayer();
                            u=0;
                            goOn=false;
                        }
                        else{
                            u=5;
                            goOn=true;
                        }
                    }
                    if(goOn){
                        if(u!=5){
                            System.out.println("Which card might you choose? If you wish to draw a card, press 0.");
                            h=yo.nextInt();
                        }
                        if(h==0&&u!=5){
                            p.add();
                            goOn=false;
                            u=3;
                        }
                        if(goOn){
                            uCard ch=p.playCard(h-1);
                      //                                   System.out.println(c+" "+ch.getCol());
                            if(c==' '){
                                if(lojic(first, ch, ' ')){
                                    System.out.println("\nYou Chose:\n"+ch.printCard()+"\n");
                                    if(p.Won()){
                                        System.out.println("\nCongrats, "+p.getName()+"! You Win!");
                                        System.exit(1);
                                    }
                                    first=ch;
                                    further=true;
                                }
                                else
                                    further=false;
                            }
                            else if(lojic(null, ch, c)){
                                System.out.println("\nYou Chose:\n"+ch.printCard()+"\n");
                                if(p.Won()){
                                    System.out.println("\nCongrats, "+p.getName()+"! You Win!");
                                    System.exit(1);
                                }
                                first=ch;
                                further=true;
                                c=' ';
                            }
                            else if(!lojic(null, ch, c))
                                further=false;
                            u=0;
                            if(further){
                                if(ch.getPow()=='s')
                                    nextPlayer();
                                else if(ch.getPow()=='d')
                                    u=1;
                                else if(ch.getPow()=='D'||ch.getPow()=='w'){
                                    if(ch.getPow()=='D')
                                        u=2;
                                    System.out.println("Which color do you choose?");
                                    String g=yo.next();
                                    c=g.charAt(0);
                                }
                                else if(ch.getPow()=='r'){
                                    if(players.size()==2)
                                        nextPlayer();
                                    rev=!rev;
                                }
                            }
                            if(further){
                                check();
                                nextPlayer();
                                check();
                            }
                            else{
                                System.out.println("Invalid!");
                                p.add(ch);
                            }
                        }
                    }
                }
            }
        
    

    static void nextPlayer(){
        if(rev)
            a--;
        else
            a++;
    }

    static void check(){
        if(rev){
            if(a<0)
                a=players.size()-1;
        }
        else if(a>=players.size())
            a=0;
        if(a==players.size()+1)            // test
            a=0;
    }

    static void draw(uPlayer x, int y){
        int what=0;
        while(what<y){
            x.add();
            what++;
        }
    }

    static boolean lojic(uCard a, uCard b, char t){
        if(a!=null)
            r1=a.getRank();
        int r2=b.getRank();
        if(a!=null)
            p1=a.getPow();
        char p2=b.getPow();
        if(a!=null)
            c1=a.getCol();
        char c2=b.getCol();
        if(p2=='w'||p2=='D')
            return true;
        if(p1!=' '&&a!=null){
        //    System.out.println("y1");
            if(c1==c2||r1==r2||p1==p2)
                return true;
            }
        if(p1==' '&&a!=null){
          //  System.out.println("y2");
            if(c1==c2||r1==r2)
                return true;
            }
        if(a==null&&c2==t){
            //System.out.println("y3");
            return true;
          }
        return false;
    }

    public static void main(String []args){
        input();
        fCard();
        play();
    }
}
