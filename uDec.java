import java.util.ArrayList;
import java.util.List;
public class uDec
{
    private List<uCard>dec=new ArrayList<>();
    public uDec(){
        int a=0;
        int b=0;
        char[]cols={'r', 'b', 'g', 'y'};
        while(a<10){
            b=0;
            while(b<4){
                dec.add(new uCard(a,cols[b],' '));
                dec.add(new uCard(a,cols[b],' '));
                b++;
            }
            a++;
        }
        b=0;
        while(b<4){
            dec.add(new uCard(-1,cols[b],'d'));
            dec.add(new uCard(-1,cols[b],'d'));
            b++;
        }
        b=0;
        while(b<4){
            dec.add(new uCard(-1,' ','D'));
            b++;
        }
        a=0;
        while(a<4){
            dec.add(new uCard(-1,' ','w'));
            a++;
        }
        b=0;
        while(b<4){
            dec.add(new uCard(-1,cols[b],'s'));
            dec.add(new uCard(-1,cols[b],'s'));
            b++;
        }
        b=0;
        while(b<4){
            dec.add(new uCard(-1,cols[b],'r'));
            dec.add(new uCard(-1,cols[b],'r'));
            b++;
        }
    }
    uCard deal(){
        if(dec.size()>0){
            int ran=(int)(Math.random()*dec.size());
            return dec.get(ran);
        }
        else
            return null;
    }
    uCard dealFirst(){
        if(dec.size()>0){
            int ran=(int)(Math.random()*dec.size());
            if(dec.get(ran).getPow()==' ')
                return dec.get(ran);
        }
        return null;
    }
    int getSize(){
        return dec.size();
    }
}