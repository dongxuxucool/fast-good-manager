package com.fastgood.dsl.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fastgood.dsl.jpa.domain.CountDO;

public interface CountDAO extends CrudRepository<CountDO, Long>{

	@Query("select c.id,c.goodId,c.remain,c.owner,g.name,g.info from CountDO c,GoodDO g WHERE c.goodId =null OR (c.goodId= g.id AND c.owner=?1)")
	public List<String> findByOwner(Long owner);
	
	/**SELECT
    f0.user_id AS d_284_id,
    d0.name AS d_284_name,
    count(f0.id) AS m_288
FROM
    mj_test_order2 f0
     JOIN 
    mj_test_user d0
     ON 
    f0.user_id = d0.id
GROUP BY
    f0.user_id,
    d0.name
    **/
	@Query("select c from CountDO c,GoodDO g WHERE c.goodId =null OR (c.goodId= g.id AND g.id=?1)")
//    @Query("SELECT n from Node n JOIN n.key k WITH k.clientId = ?1 and k.evalDate = ?2 "
//            + "WHERE n.parent is null and n.isSoftDeleted = false ")
    public CountDO find(Long id);
	
	@Query("select c.id,c.goodId,c.remain,c.owner,g.name,g.info from CountDO c,GoodDO g WHERE c.goodId =null OR (c.goodId= g.id AND g.id=?1)")
	public String findByGoodId(Long goodId);
}
