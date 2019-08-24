import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class uNO
{    
    static Scanner yo=new Scanner(System.in); 
    static List<uPlayer>players=new ArrayList<>();
    static uPlayer p;
    static uHand h;
    static uDec d;
    static uCard first;
    static int a, r1, r;
    static char c1, p1;
    static void input(){
        d=new uDec();
        System.out.println("How many players?");
        int n=yo.nextInt();
        System.out.println("Would you wish to play with the computer?\n1. Yes\n2. No");
        r=yo.nextInt();
        int a=1;
        while(a<=n){
            System.out.println("Enter Player "+a+"'s Name:");
            p=new uPlayer(yo.next());
            players.add(p);
            a++;
        }
        if(r==1)
            players.add(new uPlayer("COMP"));
    }

    static void fCard(){
        System.out.println("The card on the Table is: ");
        first=d.dealFirst();
        while(first==null)
            first=d.dealFirst();        
        System.out.println(first.toString());            
    }

    static void play(){
        a=0;
        int u=0;
        int h=0;
        int m=0;
        boolean rev=false;
        boolean further=false;
        boolean goOn=true;
        char c=' ';
        while(a<players.size()){            
            p=players.get(a);
            goOn=true;
            further=false;
            boolean no=false;
            if(a==players.size()-1){
                int chois=AI();
                if(chois!=-1){
                    System.out.println("The Computer Played:");                    
                    System.out.println(p.playCard(chois).toString());
                    a++;
                }
                else if(m==0){
                    p.add();
                    no=true;
                    m++;
                }                    
            }
            if(!no){
                if(rev){
                    if(a==-1)
                        a=players.size()-1;
                }
                else if(a>=players.size())
                    a=0;
                p=players.get(a);
                if(u==1)
                    draw(p, 2);
                else if(u==2)
                    draw(p, 4);
                if(u==3){
                    p.printHand();
                    System.out.println("Which card might you choose? If you are UNABLE to play, press 0");
                }
                else{
                    System.out.println("It's your turn, "+p.getName()+"!\n");
                    p.printHand();
                }
                if(u==3){
                    h=yo.nextInt();
                    if(h==0){
                        if(rev)
                            a--;
                        else
                            a++;
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
                        if(c==' '){
                            if(lojic(first, ch, ' ')){
                                System.out.println("You chose "+ch.toString());
                                first=ch;
                                further=true;
                            }
                            else
                                further=false;
                        }
                        else if(lojic(null, ch, c)){
                            System.out.println("You chose "+ch.toString());                        
                            first=ch;
                            further=true;
                            c=' ';
                        }
                        else if(!lojic(null, ch, c))
                            further=false;
                        u=0;
                        if(further){
                            if(ch.getPow()=='s')
                                u=4;
                            else if(ch.getPow()=='d')
                                u=1;
                            else if(ch.getPow()=='D'||ch.getPow()=='w'){
                                if(ch.getPow()=='D')
                                    u=2;
                                System.out.println("Which color do you choose?");
                                String g=yo.next();
                                c=g.charAt(0);
                            }
                            else if(ch.getPow()=='r')
                                rev=!rev; 
                        }
                        if(further){
                            if(rev)
                                a--;
                            else 
                                a++;
                            if(rev){
                                if(a==-1)
                                    a=players.size()-1;
                            }
                            else if(a>=players.size()){
                                System.out.println(a);
                                a=0;
                            }
                            if(u==4){
                                if(rev)
                                    a--;
                                else 
                                    a++;
                            }                        
                            if(rev){
                                if(a==-1)
                                    a=players.size()-1;
                            }
                            else if(a>=players.size()){
                                System.out.println("k");
                                a=0;
                            }
                        }
                        else{
                            System.out.println("Invalid!");                   
                            p.add(ch);
                        }
                    }
                }
            }
        }
    }
    
    static int AI(){
        uPlayer pl=p;
        int num=first.getRank();
        char col=first.getCol();
        char pow=first.getPow();        
        if(pl.check(-1, col, 'd')!=-1)
            return pl.check(-1, col, 'd');
        else if(pl.check(-1, col, ' ')!=-1)
            return pl.check(-1, col, ' ');
        else if(pl.check(num, ' ', ' ')!=-1)
            return pl.check(num, ' ', ' ');
        else if(pl.check(-1, ' ', 'D')!=-1)
            return pl.check(-1, ' ', 'D');
        else if(pl.check(-1, ' ', 'D')!=-1)
            return pl.check(-1, ' ', 'D');
        return -1;
    }
    
    static void draw(uPlayer x, int y){
        a=0;
        while(a<y){
            x.add();
            a++;
        }
    }

    static boolean lojic(uCard a, uCard b, char t){
        if(a!=null)
            r1=a.getRank();
        int r2=b.getRank();
        if(a!=null)
            p1=a.getPow();
        int p2=b.getPow();
        if(a!=null)
            c1=a.getCol();
        char c2=b.getCol();
        if(p2=='w'||p2=='D')
            return true;
        if(p1!=' ')
            if(c1==c2||r1==r2||p1==p2)
                return true;
        if(p1==' ')
            if(c1==c2||r1==r2)
                return true;
        if(a==null&&c2==t)
            return true;
        return false;
    }       

    static void main(){
        input();
        fCard();
        play();
    }
}