package hellotvxlet;

import java.awt.Color;
import java.util.Timer;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;


public class HelloTVXlet implements Xlet, UserEventListener {

  HScene scene;
  
  boolean isRunning = true;
  boolean isWinner = false;
  
  int time=0;
  int paddle_height = 100;
  int field_height  = 576;
  int field_width   = 720;
  int idx_cp=0;
  int [][] computerplayer={{5,200},{10,200},{15,200},{20,200},{25,200},{30,200},{35,200},{40,200},{45,200},{50,200},{55,200},{60,200},{65,150},{70,150},{75,150},{80,150},{85,150},{90,150},{95,150},{100,200},
{105,200},{110,200},{115,200},{120,200},{125,200},{130,250},{135,250},{140,250},{145,250},{150,250},{155,300},{160,300},{165,300},{170,300},{175,350},{180,350},{185,350},{190,350},{195,350},{200,350},
{205,350},{210,350},{215,350},{220,350},{225,350},{230,400},{235,400},{240,400},{245,400},{250,400},{255,400},{260,400},{265,400},{270,400},{275,400},{280,400},{285,400},{290,400},{295,400},{300,400},
{305,400},{310,400},{315,400},{320,400},{325,400},{330,400},{335,400},{340,400},{345,400},{350,400},{355,400},{360,400},{365,400},{370,400},{375,400},{380,400},{385,400},{390,400},{395,400},{400,400},
{405,400},{410,400},{415,400},{420,400},{425,400},{430,400},{435,400},{440,400},{445,400},{450,400},{455,400},{460,400},{465,400},{470,400},{475,400},{480,400},{485,400},{490,400},{495,400},{500,400},
{505,400},{510,400},{515,400},{520,400},{525,400},{530,400},{535,400},{540,400},{545,400},{550,400},{555,400},{560,400},{565,400},{570,400},{575,400},{580,400},{585,400},{590,400},{595,400},{600,400},
{605,400},{610,400},{615,400},{620,400},{625,400},{630,400},{635,400},{640,400},{645,400},{650,400},{655,400},{660,400},{665,400},{670,400},{675,400},{680,400},{685,400},{690,400},{695,400},{700,400},
{705,400},{710,400},{715,400},{720,400},{725,400},{730,400},{735,400},{740,400},{745,400},{750,400},{755,400},{760,400},{765,400},{770,400},{775,400},{780,400},{785,400},{790,400},{795,400},{800,400},
{805,400},{810,400},{815,400},{820,400},{825,400},{830,400},{835,400},{840,400},{845,400},{850,350},{855,350},{860,350},{865,350},{870,350},{875,350},{880,300},{885,300},{890,300},{895,300},{900,300},
{905,300},{910,250},{915,250},{920,250},{925,250},{930,250},{935,250},{940,250},{945,200},{950,200},{955,200},{960,200},{965,200},{970,200},{975,200},{980,200},{985,200},{990,200},{995,200},{1000,250},
{1005,250},{1010,250},{1015,250},{1020,250},{1025,250},{1030,250},{1035,250},{1040,250},{1045,250},{1050,250},{1055,250},{1060,250},{1065,250},{1070,200},{1075,200},{1080,200},{1085,200},{1090,200},{1095,200},{1100,250},
{1105,250},{1110,250},{1115,250},{1120,250},{1125,250},{1130,250},{1135,250},{1140,250},{1145,250},{1150,200},{1155,200},{1160,200},{1165,200},{1170,200},{1175,200},{1180,200},{1185,200},{1190,200},{1195,200},{1200,200},
{1205,200},{1210,200},{1215,200},{1220,200},{1225,200},{1230,200},{1235,200},{1240,200},{1245,200},{1250,200},{1255,200},{1260,200},{1265,200},{1270,200},{1275,200},{1280,200},{1285,200},{1290,200},{1295,150},{1300,150},
{1305,150},{1310,150},{1315,150},{1320,150},{1325,100},{1330,100},{1335,100},{1340,100},{1345,100},{1350,100},{1355,100},{1360,100},{1365,150},{1370,150},{1375,150},{1380,150},{1385,150},{1390,150},{1395,150},{1400,150},
{1405,200},{1410,200},{1415,200},{1420,200},{1425,200},{1430,200},{1435,200},{1440,200},{1445,200},{1450,200},{1455,200},{1460,200},{1465,200},{1470,200},{1475,200},{1480,200},{1485,200},{1490,200},{1495,200},{1500,200},
{1505,150},{1510,150},{1515,150},{1520,150},{1525,150},{1530,150},{1535,150},{1540,150},{1545,150},{1550,150},{1555,150},{1560,150},{1565,150},{1570,150},{1575,150},{1580,150},{1585,150},{1590,150},{1595,150},{1600,100},
{1605,100},{1610,100},{1615,100},{1620,100},{1625,100},{1630,100},{1635,100},{1640,100},{1645,50},{1650,50},{1655,50},{1660,50},{1665,50},{1670,50},{1675,50},{1680,50},{1685,50},{1690,50},{1695,50},{1700,50},
{1705,50},{1710,50},{1715,50},{1720,100},{1725,100},{1730,100},{1735,100},{1740,100},{1745,100},{1750,150},{1755,150},{1760,150},{1765,150},{1770,150},{1775,150},{1780,150},{1785,150},{1790,150},{1795,150},{1800,150},
{1805,150},{1810,150},{1815,200},{1820,200},{1825,200},{1830,200},{1835,200},{1840,200},{1845,200},{1850,250},{1855,250},{1860,250},{1865,250},{1870,250},{1875,250},{1880,250},{1885,250},{1890,250},{1895,250},{1900,250},
{1905,250},{1910,250},{1915,250},{1920,250},{1925,250},{1930,250},{1935,250},{1940,250},{1945,250},{1950,250},{1955,250},{1960,250},{1965,250},{1970,250},{1975,250},{1980,250},{1985,250},{1990,250},{1995,250},{2000,250},
{2005,250},{2010,250},{2015,250},{2020,250},{2025,250},{2030,250},{2035,250},{2040,250},{2045,200},{2050,200},{2055,200},{2060,200},{2065,200},{2070,200},{2075,200},{2080,200},{2085,200},{2090,150},{2095,150},{2100,150},
{2105,150},{2110,150},{2115,150},{2120,150},{2125,100},{2130,100},{2135,100},{2140,100},{2145,100},{2150,100},{2155,100},{2160,100},{2165,100},{2170,100},{2175,50},{2180,50},{2185,50},{2190,50},{2195,50},{2200,50},
{2205,50},{2210,50},{2215,50},{2220,50},{2225,50},{2230,50},{2235,50},{2240,50},{2245,50},{2250,50},{2255,50},{2260,50},{2265,50},{2270,100},{2275,100},{2280,100},{2285,100},{2290,100},{2295,100},{2300,100},
{2305,100},{2310,100},{2315,100},{2320,100},{2325,150},{2330,150},{2335,150},{2340,150},{2345,150},{2350,150},{2355,150},{2360,150},{2365,200},{2370,200},{2375,200},{2380,200},{2385,200},{2390,200},{2395,200},{2400,200},
{2405,200},{2410,200},{2415,200},{2420,200},{2425,150},{2430,150},{2435,150},{2440,150},{2445,150},{2450,150},{2455,150},{2460,150},{2465,150},{2470,150},{2475,150},{2480,150},{2485,150},{2490,150},{2495,150},{2500,150},
{2505,100},{2510,100},{2515,100},{2520,100},{2525,100},{2530,100},{2535,100},{2540,100},{2545,100},{2550,100},{2555,100},{2560,100},{2565,100},{2570,100},{2575,100},{2580,100},{2585,100},{2590,100},{2595,100},{2600,50},
{2605,50},{2610,50},{2615,50},{2620,50},{2625,50},{2630,50},{2635,50},{2640,50},{2645,50},{2650,50},{2655,50},{2660,0},{2665,0},{2670,0},{2675,0},{2680,0},{2685,0},{2690,0},{2695,50},{2700,50},
{2705,50},{2710,50},{2715,50},{2720,50},{2725,50},{2730,100},{2735,100},{2740,100},{2745,100},{2750,100},{2755,100},{2760,100},{2765,100},{2770,100},{2775,100},{2780,100},{2785,100},{2790,100},{2795,100},{2800,100},
{2805,100},{2810,100},{2815,100},{2820,50},{2825,50},{2830,50},{2835,50},{2840,50},{2845,50},{2850,50},{2855,50},{2860,0},{2865,0},{2870,0},{2875,50},{2880,50},{2885,50},{2890,50},{2895,50},{2900,100},
{2905,100},{2910,100},{2915,100},{2920,100},{2925,150},{2930,150},{2935,150},{2940,150},{2945,200},{2950,200},{2955,200},{2960,200},{2965,200},{2970,200},{2975,200},{2980,250},{2985,250},{2990,250},{2995,250},{3000,250},
{3005,250},{3010,250},{3015,250},{3020,250},{3025,250},{3030,250},{3035,250},{3040,250},{3045,250},{3050,250},{3055,250},{3060,250},{3065,250},{3070,250},{3075,250},{3080,250},{3085,250},{3090,250},{3095,250},{3100,250},
{3105,250},{3110,250},{3115,250},{3120,250},{3125,250},{3130,250},{3135,250},{3140,250},{3145,250},{3150,250},{3155,200},{3160,200},{3165,200},{3170,200},{3175,200},{3180,200},{3185,200},{3190,200},{3195,200},{3200,200},
{3205,150},{3210,150},{3215,150},{3220,150},{3225,150},{3230,150},{3235,150},{3240,150},{3245,150},{3250,150},{3255,200},{3260,200},{3265,200},{3270,200},{3275,200},{3280,200},{3285,200},{3290,200},{3295,200},{3300,200},
{3305,200},{3310,200},{3315,200},{3320,200},{3325,200},{3330,200},{3335,250},{3340,250},{3345,250},{3350,250},{3355,250},{3360,250},{3365,250},{3370,250},{3375,250},{3380,250},{3385,250},{3390,250},{3395,250},{3400,250},
{3405,250},{3410,250},{3415,250},{3420,250},{3425,300},{3430,300},{3435,300},{3440,300},{3445,300},{3450,350},{3455,350},{3460,350},{3465,350},{3470,350},{3475,400},{3480,400},{3485,400},{3490,400},{3495,400},{3500,450},
{3505,450},{3510,450},{3515,450},{3520,450},{3525,500},{3530,500},{3535,500},{3540,500},{3545,500},{3550,500},{3555,500},{3560,500},{3565,450},{3570,450},{3575,450},{3580,450},{3585,450},{3590,450},{3595,450},{3600,450},
{3605,450},{3610,450},{3615,450},{3620,450},{3625,450},{3630,450},{3635,450},{3640,450},{3645,450},{3650,450},{3655,450},{3660,450},{3665,450},{3670,450},{3675,450},{3680,450},{3685,450},{3690,450},{3695,450},{3700,450},
{3705,450},{3710,450},{3715,450},{3720,450},{3725,450},{3730,450},{3735,450},{3740,450},{3745,450},{3750,450},{3755,450},{3760,450},{3765,450},{3770,450},{3775,450},{3780,450},{3785,450},{3790,450},{3795,450},{3800,450},
{3805,450},{3810,450},{3815,450},{3820,450},{3825,450},{3830,450},{3835,450},{3840,450},{3845,450},{3850,450},{3855,450},{3860,450},{3865,450},{3870,450},{3875,450},{3880,450},{3885,450},{3890,450},{3895,450},{3900,450},
{3905,450},{3910,450},{3915,450},{3920,450},{3925,450},{3930,450},{3935,450},{3940,450},{3945,450},{3950,450},{3955,450},{3960,400},{3965,400},{3970,400},{3975,400},{3980,400},{3985,400},{3990,400},{3995,400},{4000,400},
{4005,400},{4010,400},{4015,400},{4020,400},{4025,400},{4030,400},{4035,400},{4040,400},{4045,400},{4050,400},{4055,400},{4060,400},{4065,400},{4070,400},{4075,400},{4080,450},{4085,450},{4090,450},{4095,450},{4100,450},
{4105,450},{4110,500},{4115,500},{4120,500},{4125,500},{4130,500},{4135,500},{4140,500},{4145,500},{4150,500},{4155,500},{4160,500},{4165,500},{4170,500},{4175,450},{4180,450},{4185,450},{4190,450},{4195,450},{4200,450},
{4205,450},{4210,450},{4215,400},{4220,400},{4225,400},{4230,400},{4235,400},{4240,400},{4245,400},{4250,400},{4255,400},{4260,400},{4265,400},{4270,400},{4275,400},{4280,400},{4285,400},{4290,400},{4295,400},{4300,400},
{4305,400},{4310,400},{4315,400},{4320,400},{4325,400},{4330,400},{4335,400},{4340,400},{4345,400},{4350,400},{4355,400},{4360,400},{4365,400},{4370,400},{4375,400},{4380,400},{4385,400},{4390,400},{4395,400},{4400,400},
{4405,400},{4410,400},{4415,400},{4420,400},{4425,400},{4430,400},{4435,400},{4440,400},{4445,400},{4450,400},{4455,400},{4460,400},{4465,400},{4470,400},{4475,400},{4480,400},{4485,400}};
      
  HStaticText winner=    new HStaticText("YOU WIN!", 310, 270, 100, 50);  
  HStaticText gameOver = new HStaticText("GAME OVER!", 270, 270, 150, 50);
  HStaticText restart = new HStaticText("move paddle to restart", 225, 320, 250, 50);
    
  
  
  Player player;
  Player player2;
  
  Ball ball;
  
  Score points;
  int max_score = 10;
  int ball_speed= 4;
  int paddle_speed= 60;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
     //720 x 576
     //x,y,width,heigth in px
        
     player = new Player (0,0, field_width, field_height);
     player2 = new Player (0,0, field_width, field_height);
   
     ball = new Ball (0,0, field_width, field_height);
     
     points = new Score(200,10,field_width, field_height);
     
     scene = HSceneFactory.getInstance().getDefaultHScene();
     scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
     scene.setBackground(Color.BLACK);
  
     scene.add(player);
     scene.add(ball);
     scene.add(player2);
     scene.add(points);
   
     scene.validate();
     scene.setVisible(true);
     
     UserEventRepository rep = new UserEventRepository("naam");
     rep.addAllArrowKeys();
     rep.addKey(HRcEvent.VK_ENTER);
     EventManager.getInstance().addUserEventListener(this, rep);
     
     player.pos_y = 200;
     player.pos_x=20;
     player2.pos_x= 690;
     player2.pos_y = 200;
    
    }

    public void startXlet() {
    Timer t=new Timer();
    MijnTimerTask mtt=new MijnTimerTask(this);
    t.scheduleAtFixedRate(mtt, 0,ball_speed);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
     

    public void userEventReceived(UserEvent e) {
      if (e.getType()==HRcEvent.KEY_PRESSED)
      {
           
        if(e.getCode() == HRcEvent.VK_UP && player.pos_y>0){
            player.pos_y-= paddle_speed;
            player.repaint();
        }
        if(e.getCode() == HRcEvent.VK_DOWN && player.pos_y<(field_height - paddle_height)){
            player.pos_y+=paddle_speed;
            player.repaint();
        }
        
        if(e.getCode() == HRcEvent.VK_LEFT && player2.pos_y<(field_height - paddle_height)){
            player2.pos_y+=paddle_speed;
            player2.repaint();
        }
        if(e.getCode() == HRcEvent.VK_RIGHT && player2.pos_y>0){
            player2.pos_y-=paddle_speed;
            player2.repaint();  
        }
        if(e.getCode() == HRcEvent.VK_ENTER && !isRunning){
            restart();
        }
        if(!isRunning){
           if(e.getCode() == HRcEvent.VK_UP || e.getCode() == HRcEvent.VK_DOWN){ 
           restart();
        } 
        }
      }
    }
    public void restart(){
        isRunning = true;
        points.player1 = 0;
        points.player2 = 0;
        isWinner = false;
        
        scene.remove(winner);
        scene.remove(gameOver);
        scene.remove(restart);
        scene.repaint();   
    } 
    public void runGame(){
        if(isRunning){
            //player.pos_y=ball.pos_y-40;
            time++;
            if (time%5==0)
            {
                player2.pos_y=computerplayer[idx_cp][1];
                idx_cp++;
                if (idx_cp>=computerplayer.length) idx_cp=0;
                //System.out.print("{"+time+","+player2.pos_y+"},");
            }
           
          //if (time%100==0) System.out.println("");
            
            
          ball.move();
          ball.repaint();
          checkCollision();
      
        }
    }
    
    public void checkCollision(){
        int staal=ball.radius/2;
        
        if(ball.pos_x <= player.pos_x+player.paddle_width){
           if(ball.pos_y >= player.pos_y-staal &&  ball.pos_y+ball.radius <= player.pos_y+player.paddle_height+staal) {
                ball.direction_x = true;
            }
        }
        if(ball.pos_x + ball.radius >= player2.pos_x){
           if(ball.pos_y >= player2.pos_y-staal &&  ball.pos_y <= player2.pos_y+player2.paddle_height-ball.radius+staal){
                ball.direction_x = false;
            }
        }
        
        if(ball.pos_x == 0){
            points.player2 ++;
            
        }
        
        if(ball.pos_x + ball.radius == field_width){
            points.player1 ++;
        }
        
        if(points.player1 >= max_score || points.player2 >= max_score ){
            isRunning = false;
            if(points.player1 >= max_score){
                isWinner = true;
            }
            else{
                isWinner = false;
            }
                if(!isRunning){
         if(isWinner){
           scene.add(winner); 
          
           System.out.println("player1 wins");
         }
         else{
             scene.add(gameOver);
             
             System.out.println("player2 wins");
         }
         scene.add(restart);
         scene.repaint();
     }
        }    
    }
}
