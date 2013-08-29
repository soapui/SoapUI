
/**
 * Created with IntelliJ IDEA.
 * User: wiklundn
 * Date: 2013-08-26
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */

/*
*  soapUI Pro, copyright (C) 2007-2011 eviware software ab
*/

package soapui.init

import groovy.sql.*;
import com.eviware.soapui.impl.wsdl.WsdlInterface
import com.eviware.soapui.SoapUI.*
import com.eviware.soapui.support.GroovyUtils
import com.eviware.soapui.model.*
import com.eviware.soapui.support.scripting.*
import com.eviware.soapui.model.project.*

class InitProperty

{
    def name
    def vmsUserId_user
    def vmsUserId_admin
    def vmauserid
    def sql = groovy.sql.Sql.newInstance("jdbc:oracle:thin:@zvss2:1521:DP9A", "vms_core_o", "vms", 'oracle.jdbc.driver.OracleDriver')

    Property(propertyName)
    {
        name = propertyName;
    }

    def fetchparam () {
        sql.firstRow("select vmsuserid from (select vmsuserid from customer cu, corporate co where cu.corporate_id=co.corporate_id ORDER BY dbms_random.value) where rownum <= 1")
        sql
    }

}
