import java.util.ArrayList;
import java.util.List;

/**
 * Contains the arrayList in which all the 100 random numbers are stored.
 *
 * @author Adam Jaamour
 * @version 1.0
 * @release 01/12/2015
 * @See SRPN.java
 */

public class SRPNRandom {

    List<Integer> randomArray;
    int i = -1; //integer used to push specific element of the arrayList to the stack

    /**
     * Constructor. Sets the ArrayList of random numbers.
     */
    public SRPNRandom(){
        randomArray = new ArrayList<Integer>();
        addSRPNRandom();
    }

    /**
     * returns a random number from they list in the order they were entered. If the end of the list of the
     * 100 random numbers is reached, then the i is reset to 0 so that the list restarts when r is typed by
     * the user.
     *
     * @return random number.
     */
    public Integer listSRPNRandom(){
        i++;
        if (i == 100){
            i = -1;
        }
        return(randomArray.get(i));
    }

    /**
     * adds the random numbers to the ArrayList.
     */
    private void addSRPNRandom(){
        //SRPNRandom random = new SRPNRandom();
        randomArray.add(1804289383);
        randomArray.add(846930886);
        randomArray.add(1681692777);
        randomArray.add(1714636915);
        randomArray.add(1957747793);
        randomArray.add(424238335);
        randomArray.add(719885386);
        randomArray.add(1649760492);
        randomArray.add(596516649);
        randomArray.add(1189641421);
        randomArray.add(1025202362);
        randomArray.add(1350490027);
        randomArray.add(783368690);
        randomArray.add(1102520059);
        randomArray.add(2044897763);
        randomArray.add(1967513926);
        randomArray.add(1365180540);
        randomArray.add(1540383426);
        randomArray.add(304089172);
        randomArray.add(1303455736);
        randomArray.add(35005211);
        randomArray.add(521595368);
        randomArray.add(294702567);
        randomArray.add(1726956429);
        randomArray.add(336465782);
        randomArray.add(861021530);
        randomArray.add(278722862);
        randomArray.add(233665123);
        randomArray.add(2145174067);
        randomArray.add(468703135);
        randomArray.add(1101513929);
        randomArray.add(1801979802);
        randomArray.add(1315634022);
        randomArray.add(635723058);
        randomArray.add(1369133069);
        randomArray.add(1125898167);
        randomArray.add(1059961393);
        randomArray.add(2089018456);
        randomArray.add(628175011);
        randomArray.add(1656478042);
        randomArray.add(1131176229);
        randomArray.add(1653377373);
        randomArray.add(859484421);
        randomArray.add(1914544919);
        randomArray.add(608413784);
        randomArray.add(756898537);
        randomArray.add(1734575198);
        randomArray.add(1973594324);
        randomArray.add(149798315);
        randomArray.add(2038664370);
        randomArray.add(1129566413);
        randomArray.add(184803526);
        randomArray.add(412776091);
        randomArray.add(1424268980);
        randomArray.add(1911759956);
        randomArray.add(749241873);
        randomArray.add(137806862);
        randomArray.add(42999170);
        randomArray.add(982906996);
        randomArray.add(135497281);
        randomArray.add(511702305);
        randomArray.add(2084420925);
        randomArray.add(1937477084);
        randomArray.add(1827336327);
        randomArray.add(572660336);
        randomArray.add(1159126505);
        randomArray.add(805750846);
        randomArray.add(1632621729);
        randomArray.add(1100661313);
        randomArray.add(1433925857);
        randomArray.add(1141616124);
        randomArray.add(84353895);
        randomArray.add(939819582);
        randomArray.add(2001100545);
        randomArray.add(1998898814);
        randomArray.add(1548233367);
        randomArray.add(610515434);
        randomArray.add(1585990364);
        randomArray.add(1374344043);
        randomArray.add(760313750);
        randomArray.add(1477171087);
        randomArray.add(356426808);
        randomArray.add(945117276);
        randomArray.add(1889947178);
        randomArray.add(1780695788);
        randomArray.add(709393584);
        randomArray.add(491705403);
        randomArray.add(1918502651);
        randomArray.add(752392754);
        randomArray.add(1474612399);
        randomArray.add(2053999932);
        randomArray.add(1264095060);
        randomArray.add(1411549676);
        randomArray.add(1843993368);
        randomArray.add(943947739);
        randomArray.add(1984210012);
        randomArray.add(855636226);
        randomArray.add(1749698586);
        randomArray.add(1469348094);
        randomArray.add(1956297539);
    }
}