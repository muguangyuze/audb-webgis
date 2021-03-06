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
package it.cnr.igag.audb.service;

import it.cnr.igag.audb.domain.Utente;
import it.cnr.igag.audb.vo.Result;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 *
 * @author Francesco Pennica <francesco.pennica at igag.cnr.it>
 */
public class UtenteServiceTest extends AbstractServiceForTesting {
    
    protected final int TEST_USER_ID = 3;
    @Autowired(required = true)
    protected UtenteService utenteService;
    
    @Test
    //@Rollback(false)
    public void testUpdateProgettoDefaultAudb() throws Exception {
        
        Result<Utente> result = utenteService.updateProgettoDefaultAudb(9, TEST_USER_ID);
        
        Utente u = result.getData();
        
        assertTrue(u.getProgettoDefaultAudb().getId() == 9);
        
        logger.debug("Utente {} now has new ProgettoDefaultAudb with id: {}", u.getUsername(), u.getProgettoDefaultAudb().getId());
        
    }
    
}
