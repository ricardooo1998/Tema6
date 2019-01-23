package Programa;
import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hola mundo");
		
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		/*Empresa emp1 = new Empresa();
		emp1.setCif("123456");
		emp1.setNombre("Jamaizon");
		emp1.setEmpleados(20);
		emp1.setDirreccion("Valencia");
		session.save(emp1);
		
		
		
		Pedido ped1 = new Pedido();
		ped1.setId(0);
		ped1.setFecha("2019-01-23");
		session.save(ped1);
		
		
		
		Item item1 = new Item();
		item1.setId(0);
		item1.setNombre("ordenadores");
		item1.setCantidad(2);
		session.save(item1);
		*/
		Empresa empresa = session.get(Empresa.class, "123456");
		System.out.println("Hemos recuperado de la tabla empresa: "+empresa.getCif()+" "+empresa.getNombre()+" "+empresa.getEmpleados()+" "+empresa.getDirreccion());
		
		Pedido pedido = session.get(Pedido.class, 0);
		System.out.println("Hemos recuperado de la tabla pedido: "+pedido.getId()+" "+pedido.getFecha());
		
		Item item = session.get(Item.class, 0);
		System.out.println("Hemos recuperado de la tabla item: "+item.getId()+" "+item.getNombre()+" "+item.getCantidad());
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtilities.getSessionFactory().close();
		
		
		

	}

}
