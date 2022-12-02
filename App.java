import DTO.NV_DTO;
import Function.MyEvent;
import GUI.LoginFrame;
import GUI.MainFrame;


public class App {

    private static NV_DTO user = null;
    public static void main(String[] args){
        MainFrame mf = new MainFrame();
        LoginFrame li = new LoginFrame();
        li.setVisible(true);
        li.addSwitchFrameEvent(new MyEvent() {
            @Override
            public void switchFrame() {
                user = li.getUser();
                mf.initPanel(user);
                mf.setVisible(true);
                li.dispose();
            }
        });
        mf.addSwitchFrameEvent(new MyEvent() {
            @Override
            public void switchFrame() {
                li.setVisible(true);
                user =null;
                mf.dispose();
            }
        });
    }
}
