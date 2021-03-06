/*
 * Copyright (C) 2014 Francesco Pennica <francesco.pennica at igag.cnr.it>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.cnr.igag.audb.dao;

import it.cnr.igag.audb.domain.AllagamentiOsservFonti;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francesco Pennica <francesco.pennica at igag.cnr.it>
 */
@Repository("allagamentiOsservFontiDaoImpl")
@Transactional
public class AllagamentiOsservFontiDaoImpl extends GenericDaoImpl<AllagamentiOsservFonti, Integer> implements AllagamentiOsservFontiDao {

    public AllagamentiOsservFontiDaoImpl() {
        super(AllagamentiOsservFonti.class);
    }

    @Override
    @Transactional(readOnly = true, propagation
            = Propagation.SUPPORTS)
    public List<AllagamentiOsservFonti> findAll() {
        return em.createNamedQuery("AllagamentiOsservFonti.findAll")
                .getResultList();
    }
    
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public AllagamentiOsservFonti findReferenceById(Integer idFonte) {
        
        return em.getReference(AllagamentiOsservFonti.class, idFonte);
    }
    
}
