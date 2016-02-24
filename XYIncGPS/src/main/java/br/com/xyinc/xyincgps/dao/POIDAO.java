package br.com.xyinc.xyincgps.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.xyinc.xyincgps.model.POI;
import br.com.xyinc.xyincgps.util.EntityManagerUtil;

public class POIDAO {

	private static POIDAO inst;
	private EntityManager em;
	private EntityManagerUtil emUtil = new EntityManagerUtil();
	
	
	public static POIDAO getInstance(){
		if (inst == null) {
			inst = new POIDAO();
		}
		return inst;
	}
	
	@SuppressWarnings("static-access")
	private EntityManager getEntiManager(){
		if ( em == null ) {
			try {
				this.em = emUtil.getEntityManager();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return em;
	}
	
	@SuppressWarnings("unchecked")
	public List<POI> listFull(){
		return getEntiManager().createQuery( "FROM POI").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<POI> listByReferences(Integer referenceX, Integer referenceY){
		List<POI> poiList = getEntiManager().createQuery(" FROM POI a where a.referenceX = :referenceX and a.referenceY = :referenceY ")
											.setParameter("referenceX", referenceX)
											.setParameter("referenceY", referenceY)
											.getResultList();
		
		getEntiManager().close();
		return poiList;
	}
	
	@SuppressWarnings("unchecked")
	public List<POI> listByProximity(Integer referenceX, Integer referenceY, Integer maxDistance){
		Integer xMax = referenceX + maxDistance;
		Integer xMin = referenceX - maxDistance;
		Integer yMax = referenceY + maxDistance;
		Integer yMin = referenceY - maxDistance;
		
		List<POI> poiList = getEntiManager().createQuery(" FROM POI a where (a.referenceX <= :xMax and a.referenceX >= :xMin) and (a.referenceY <= :yMax and a.referenceY >= :yMin) ")
											.setParameter("xMax", xMax)
											.setParameter("xMin", xMin)
											.setParameter("yMax", yMax)
											.setParameter("yMin", yMin)
											.getResultList();
		
		getEntiManager().close();
		return poiList;
	}
	
	public POI merge(POI poi){
		try {
			getEntiManager().getTransaction().begin();
			poi = getEntiManager().merge(poi);
			getEntiManager().getTransaction().commit();
			return poi;
		} catch (Exception e) {
			e.printStackTrace();
			getEntiManager().getTransaction().rollback();
			throw e;
		} finally {
			getEntiManager().close();
		}
	}

	public void delete(POI poi){
		try {
			getEntiManager().getTransaction().begin();
			getEntiManager().remove(poi);
			getEntiManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			getEntiManager().getTransaction().rollback();
			throw e;
		} finally {
			getEntiManager().close();
		}
	}
	
}
