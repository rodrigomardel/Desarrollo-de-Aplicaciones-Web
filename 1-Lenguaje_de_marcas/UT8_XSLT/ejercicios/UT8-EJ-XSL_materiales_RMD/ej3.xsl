<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="/">
        <html>
            
            <head>
                <style>
                    .verde{background-color:lightgreen;}
                    .amarillo{background-color:lightyellow;}
                    .azul{background-color:blue;}
                    .rojo{color:red;}
                    .fondoRojo{background-color:red;}
                    body{background-color:grey;}
                    table{background-color:lightred;}
                </style>
            </head>
            
            <body>
                <h1>
                    <xsl:attribute name="class">
                        <xsl:text>rojo</xsl:text>
                    </xsl:attribute>
                    <xsl:text>Lista de vuelos</xsl:text>
                </h1>
                
                <xsl:for-each select="//vuelo[ruta/aeropuerto_origen='CDG']">
                    <h2><xsl:value-of select="numero"/></h2>
                    <h3><xsl:value-of select="avion"/></h3>
                    
                    <table border="1">
                        <tr>
                            <th><xsl:text>Origen</xsl:text></th>          
                            <th><xsl:text>Destino</xsl:text></th>               
                            <th><xsl:text>Fecha</xsl:text></th>               
                        </tr>
                        <tr>
                            <td><xsl:value-of select="ruta/aeropuerto_origen"/></td>          
                            <td><xsl:value-of select="ruta/aeropuerto_destino"/></td>               
                            <td>
                                <xsl:choose>
                                    <xsl:when test="ruta/fecha_salida/substring(.,7)&lt;'2010'">
                                        <xsl:attribute name="class">
                                            <xsl:text>fondoRojo</xsl:text>
                                        </xsl:attribute>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <xsl:attribute name="class">
                                            <xsl:text>verde</xsl:text>
                                        </xsl:attribute>
                                    </xsl:otherwise>
                                </xsl:choose>
                                <xsl:value-of select="ruta/fecha_salida"/>
                            </td>               
                        </tr>                                                 
                    </table>
                    <br></br>
                    <table border="1">
                        <tr>
                            <th><xsl:text>Piloto</xsl:text></th>          
                            <th><xsl:text>Copiloto</xsl:text></th>               
                        </tr>
                        <tr>
                            <td><xsl:value-of select="pilotos/CDB"/></td>          
                            <td><xsl:value-of select="pilotos/COPI"/></td>               
                        </tr>                                                 
                    </table>    
                    <br></br>
                    <table border="1">
                        <tr>
                            <th><xsl:text>Número</xsl:text></th>          
                            <th><xsl:text>Puesto</xsl:text></th>
                            <th><xsl:text>Nombre</xsl:text></th>                                          
                        </tr>
                        <tr>
                            <td><xsl:text>1</xsl:text></td>          
                            <td><xsl:value-of select="PNC/JEFECABINA/name()"/></td> 
                            <td><xsl:value-of select="PNC/JEFECABINA"/></td>                          
                        </tr>    
                        <xsl:for-each select="PNC/AUXILIAR">
                            <tr>
                                <td><xsl:number value="position()"/></td>
                                <td><xsl:value-of select="./name()"/></td>
                                <td><xsl:value-of select="."/></td>
                            </tr>
                        </xsl:for-each> <!--auxiliar-->
                        <xsl:for-each select="PNC/AZAFATA">
                            <tr>
                                <td><xsl:number value="position()"/></td>
                                <td><xsl:value-of select="./name()"/></td>
                                <td><xsl:value-of select="."/></td>
                            </tr>
                        </xsl:for-each> <!--azafata-->                                              
                    </table>                  
                </xsl:for-each> <!--vuelo-->            
            </body>
        </html>  
    </xsl:template>   
</xsl:stylesheet>