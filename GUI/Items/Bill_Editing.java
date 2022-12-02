package GUI.Items;


import java.util.ArrayList;

import BLL.CTHD_BLL;
import BLL.HD_BLL;
import BLL.SP_BLL;
import BLL.Statistic_BLL;
import DTO.CTHD_DTO;
import DTO.HD_DTO;
import DTO.NV_DTO;

public class Bill_Editing extends Bill_Details{
    ArrayList<CTHD_DTO> oldDetails;
    HD_DTO oldBill;
    private HD_BLL hd_BLL = new HD_BLL();
    private CTHD_BLL cthd_BLL = new CTHD_BLL();
    private SP_BLL sp_BLL = new SP_BLL();
    private Statistic_BLL statistic_BLL = new Statistic_BLL();
    

    public Bill_Editing(NV_DTO worker, String ID){
        super(worker);
        Bill = hd_BLL.getBil(ID);
        details = cthd_BLL.getDetails(ID);
        
        oldBill = hd_BLL.getBil(ID);
        oldDetails = cthd_BLL.getDetails(ID);
        
        products = new ArrayList<>();
        for (CTHD_DTO row : details) {
            products.add(sp_BLL.Find(row.getMasp()));
        }
        rebuildTable();
    }

    @Override
    public void saveBillEvent() {
        
                
        
        String[] date = oldBill.getNgxuat().split(" ");
        int Sold = 0;
            for (CTHD_DTO cthd_DTO : oldDetails) {
                Sold += cthd_DTO.getSoluong();
            }
        statistic_BLL.decData(date[0], Bill.getTongtien()/1000, Sold);
        
        Sold = 0;
        for (CTHD_DTO cthd_DTO : details) {
            Sold += cthd_DTO.getSoluong();
        }
        statistic_BLL.addData(date[0], Bill.getTongtien()/1000, Sold);
        

        hd_BLL.Edit(Bill, Bill.getMahd(), details);   
    }
}
