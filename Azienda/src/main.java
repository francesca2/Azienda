import java.util.List;

import model.Rubrica;
import model.Voce;
import it.alfasoft.francesca.bean.AdminBean;
import it.alfasoft.francesca.bean.ClienteBean;
import it.alfasoft.francesca.dao.AdminDao;
import it.alfasoft.francesca.dao.ClienteDao;
import it.alfasoft.francesca.dao.RubricaDao;
import it.alfasoft.francesca.dao.UtenteDao;
import it.alfasoft.francesca.service.Servizi;


public class main {

	public static void main(String[] args) {
Servizi s= new Servizi();
AdminDao adao= new AdminDao();
UtenteDao udao=new UtenteDao();

AdminBean a= new AdminBean("Francesca", "Giordani", "admin", "root",'a',"primo");
a.setPassword(s.convertiPass("root"));
adao.createAdmin(a);
//ClienteBean c= new ClienteBean("nome","cognome","username","12345",'c',"alfasoft","123fkas");
//ClienteDao cdao=new ClienteDao();
////RubricaBean r= s.trovaRubrica("username");
//Rubrica r= new Rubrica();
//RubricaDao rdao= new RubricaDao();
//r.setNomeRubrica("username");
//rdao.creaRubrica(r);
//c.setPassword(s.convertiPass("12345"));
//s.registraCliente(c);
//Voce v= new Voce("Francesca","Giordani","3901747");
//s.registraVoce(r, v);
//
//UtenteDao udao= new UtenteDao();
//ClienteBean c1= (ClienteBean) s.getUtente("username");
//
//System.out.println(c1.getRagioneSociale());
//
//List<Voce> ll=s.getVoci(r);
//
//System.out.println(ll.get(0).getNomeVoce());

//for(VoceBean vv : ll)
//{
//	System.out.println(vv.getNomeVoce());
//}
	}

}
