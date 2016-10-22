import model.Rubrica;
import it.alfasoft.francesca.bean.ClienteBean;
import it.alfasoft.francesca.dao.ClienteDao;
import it.alfasoft.francesca.dao.UtenteDao;
import it.alfasoft.francesca.service.Servizi;


public class main {

	public static void main(String[] args) {
Servizi s= new Servizi();

ClienteBean c= new ClienteBean("nome","cognome","username","12345",'c',"alfasoft","123fkas");
ClienteDao cdao=new ClienteDao();
Rubrica r= new Rubrica();
r.setNomeRubrica("username");
c.setPassword(s.convertiPass("12345"));
s.registraCliente(c);

UtenteDao udao= new UtenteDao();
ClienteBean c1= (ClienteBean) s.getUtente("username");

System.out.println(c1.getRagioneSociale());

	}

}
