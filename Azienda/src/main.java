import java.util.List;

import it.alfasoft.francesca.bean.ClienteBean;
import it.alfasoft.francesca.bean.RubricaBean;
import it.alfasoft.francesca.bean.VoceBean;
import it.alfasoft.francesca.dao.ClienteDao;
import it.alfasoft.francesca.dao.RubricaDao;
import it.alfasoft.francesca.dao.UtenteDao;
import it.alfasoft.francesca.service.Servizi;


public class main {

	public static void main(String[] args) {
Servizi s= new Servizi();

ClienteBean c= new ClienteBean("nome","cognome","username","12345",'c',"alfasoft","123fkas");
ClienteDao cdao=new ClienteDao();
RubricaBean r= s.trovaRubrica("username");
RubricaDao rdao= new RubricaDao();
//r.setNomeRubrica("username");
//rdao.creaRubrica(r);
//c.setPassword(s.convertiPass("12345"));
//s.registraCliente(c);
//VoceBean v= new VoceBean("Francesca","Giordani","3901747");
//s.registraVoce(r, v);
//
//UtenteDao udao= new UtenteDao();
//ClienteBean c1= (ClienteBean) s.getUtente("username");
//
//System.out.println(c1.getRagioneSociale());

List<VoceBean> lista=s.getVoci(r);

for(VoceBean vbean: lista)
{
	System.out.println(vbean.getNomeVoce());
}
	}

}
