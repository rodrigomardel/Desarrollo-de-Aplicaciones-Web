<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">
    
    <xsl:output method="html" indent="yes"/>
    
    <xsl:template match="/">      
        <html>
            <head>
                <h1><xsl:text>Empleados</xsl:text></h1>
            </head>
            <body>
                
                <table>
                    <xsl:attribute name="border">
                        <xsl:text>2</xsl:text>
                    </xsl:attribute>
                    <tr>
                        <th><xsl:text>ID</xsl:text></th>
                        <th><xsl:text>Nombre</xsl:text></th>
                        <th><xsl:text>Profesión</xsl:text></th>
                        <th><xsl:text>Salario</xsl:text></th>
                        <th><xsl:text>Observaciones</xsl:text></th>        
                    </tr>
                    <xsl:for-each select="//empleado[profesion/text()='Administrativo' or 'Ingeniero']">
                        <xsl:sort select="salario"/>
                        <tr>
                            <td><xsl:value-of select="@rut"/></td>
                            <td><xsl:value-of select="nombre"/></td>
                            <td><xsl:value-of select="profesion"/></td>
                            <td><xsl:value-of select="salario"/></td>
                            <td>
                                <xsl:if test="salario&lt;15000">
                                    <xsl:text>*Aumentar salario</xsl:text>                  
                                </xsl:if>
                            </td>
                        </tr>                    
                        
                    </xsl:for-each>
                </table>
                
            </body>
        </html>
    </xsl:template>
    
    
</xsl:stylesheet>