package bikeShare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bikeShare.common.ConnDB;
import bikeShare.common.CrudModel;
import bikeShare.model.Address;
import bikeShare.model.ImagePath;

public class AddressDaoImpl {
	Connection  ct=null;
	PreparedStatement ps=null;
	ResultSet  rs=null;

	
	public Address queryAddressByPramryKey(String  id){
//		System.out.println("wtf??????");	
		Address address=null;
		String sql="select * from address where addressId=?";
		String  paras[]={id};
		CrudModel  cmd=new CrudModel();
		rs=cmd.queryExecute(sql, paras);
		try {
			while(rs.next()){
				
				address=new Address();
				address.setAddressname(rs.getString("addressName"));;
				address.setAddressid(rs.getInt("addressId"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			new ConnDB().close();
			
		}
		
		return address;
		
	}
	
	public List<Address> queryAddresslist(){
		
		List<Address> alist=new ArrayList<Address>();
		String sql="select * from address ";
		
		CrudModel  cmd=new CrudModel();
		rs=cmd.queryAll(sql);
		try {
			while(rs.next()){
				
				Address	address=new Address();
				address.setAddressname(rs.getString("addressName"));;
				address.setAddressid(rs.getInt("addressId"));
				alist.add(address);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			new ConnDB().close();
			
		}
		
		return alist;
		
	}
}
