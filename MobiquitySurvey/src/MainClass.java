//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import com.mobiquity.snack.model.ContactDetailEntity;
//import com.mobiquity.snack.model.RoleEntity;
//import com.mobiquity.snack.model.UserEntity;
//
//public class MainClass {
//	public static void main(String[] args) {
//		
//
//		System.out.println(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		Session session = Util.getSessionFactory().openSession();
//		session.beginTransaction();
//		try {
//			RoleEntity role = new RoleEntity();
//			//role.setRoleId(1);
//			role.setRoleName("USER");
//			session.save(role);
//			RoleEntity role2 = new RoleEntity();
//			//role2.setRoleId(2);
//			role2.setRoleName("ADMIN");
//			session.save(role2);
//			
//			
//			UserEntity user = new UserEntity();
//			//user.setUserId(1l);
//			user.setActive(true);
//			user.setFirstName("ravi");
//			user.setLastName("nair");
//			user.setMiddleName("g");
//			user.setSalt("abc4334Df");
//			user.setPassword("ravi123");
//			user.setBirthDate(new Date());
//			user.setUserName("ravi21101991@gmail.com");
//			Set<RoleEntity> roleSet=new HashSet<RoleEntity>();
//			
//			ContactDetailEntity contactDetailEntity = new ContactDetailEntity();
//			contactDetailEntity.setMobileNumber(9725094398l);
//			contactDetailEntity.setPermenantAddress("10 yash sagar society opp modi hall");
//			contactDetailEntity.setTemporaryAddress("same as perm");
//			contactDetailEntity.setUserId(user);
////			UserEntity user2 = new UserEntity();
////			//user.setUserId(1);
////			user2.setActive(true);
////			user2.setFirstName("dhara");
////			user2.setLastName("nair");
////			user2.setMiddleName("g");
////			user2.setSalt("abc4334Df");
////			user2.setPassword("dhara");
////			user2.setUserName("dhara@gmail.com");
//			
//			ContactDetailEntity contactDetailEntity2 = new ContactDetailEntity();
//			contactDetailEntity2.setMobileNumber(5555555);
//			contactDetailEntity2.setPermenantAddress("20 yash sagar society opp modi hall");
//			contactDetailEntity2.setTemporaryAddress("same as permenant address");
//		//	contactDetailEntity2.setUserId(user2);
//			
//			
////			UserEntity user1 = new UserEntity();
////			//user.setUserId(1);
////			user1.setActive(true);
////			user1.setFirstName("tirth");
////			user1.setLastName("mulani");
////			user1.setMiddleName("g");
////			user1.setSalt("abc4334Df");
////			user1.setPassword("tirth123");
////			user1.setUserName("tirth@gmail.com");
//			
//			roleSet.add(role);
//			roleSet.add(role2);
//			
//			user.setUserRole(role);
//	//		user2.setUserRole(role2);
//			
//			
//			session.save(user);
//			session.save(role);
//			session.save(contactDetailEntity);
//	//		session.save(user2);
//			session.save(role);
//			session.save(contactDetailEntity2);
//			//	session.save(user1);
//			
//			
////			Query query=session.createQuery("from User");
////			List<User> list=query.list();
////			query.setFirstResult(4);
////			query.setMaxResults(5);
////			for(User roles:list){
////				System.out.println(roles.getFirstName());
////			}
//			Criteria criteria= session.createCriteria(UserEntity.class);
//			criteria.add(Restrictions.eq("firstName", "ravi"));
//			@SuppressWarnings({ "unchecked", "unused" })
//			List<UserEntity> list=criteria.list();
//			
//			
//
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		} finally {
//			session.getTransaction().commit();
//			session.close();
//		}
//
//	}
//}
