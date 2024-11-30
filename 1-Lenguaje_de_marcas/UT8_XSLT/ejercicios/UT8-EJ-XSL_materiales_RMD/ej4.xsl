<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="/">
        <html>
            <head>
                <link rel="stylesheet" href="ej4.css"/>
            </head>
            <body>
                <h1><xsl:text>Resultado de las elecciones</xsl:text></h1>
                <h2>
                    <xsl:value-of select="escrutinio_sitio/nombre_sitio"/>
                    <xsl:text>. Convocatoria:</xsl:text>
                    <xsl:value-of select="escrutinio_sitio/convocatoria"/>
                </h2>
                
                <main>
                    <div>
                        <ul>
                            <li>
                                <xsl:text>Total de votos: </xsl:text>
                                <xsl:value-of select="//votos/contabilizados/cantidad"/>
                                <xsl:text> (</xsl:text>
                                <xsl:value-of select="//votos/contabilizados/porcentaje"/>
                                <xsl:text>%)</xsl:text>                      
                            </li>
                            <li>
                                <xsl:text>Abstenciones: </xsl:text>
                                <xsl:value-of select="//votos/abstenciones/cantidad"/>
                                <xsl:text> (</xsl:text>
                                <xsl:value-of select="//votos/contabilizados/porcentaje"/>
                                <xsl:text>%)</xsl:text>
                            </li>
                            <li>
                                <xsl:text>Nulos: </xsl:text>
                                <xsl:value-of select="//votos/nulos/cantidad"/>
                                <xsl:text> (</xsl:text>
                                <xsl:value-of select="//votos/contabilizados/porcentaje"/>
                                <xsl:text>%)</xsl:text>
                            </li>
                            <li>
                                <xsl:text>En blanco: </xsl:text>
                                <xsl:value-of select="//votos/blancos/cantidad"/>
                                <xsl:text> (</xsl:text>
                                <xsl:value-of select="//votos/contabilizados/porcentaje"/>
                                <xsl:text>%)</xsl:text>
                            </li>             
                        </ul>
                    </div>
                    <div>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>Partido</th>
                                <th>Nº Votos</th>
                                <th>Porcentaje</th>
                            </tr>
                            <xsl:for-each select="//partido[votos_porciento>1]">
                                <xsl:sort select="number(votos_porciento)"/>
                                <tr>
                                    <xsl:choose>
                                        <xsl:when test="position() mod 2">
                                            <xsl:attribute name="class">
                                                <xsl:text>impar</xsl:text>
                                            </xsl:attribute>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <xsl:attribute name="class">
                                                <xsl:text>par</xsl:text>
                                            </xsl:attribute>
                                        </xsl:otherwise>
                                    </xsl:choose> 
                                    <td><xsl:value-of select="id_partido"/></td>
                                    <td><xsl:value-of select="nombre"/></td>
                                    <td><xsl:value-of select="votos_numero"/></td>
                                    <td><xsl:value-of select="votos_porciento"/></td>     
                                </tr>
                                
                            </xsl:for-each>
                            <tr>
                                <td>
                                    <xsl:attribute name="colspan">
                                        <xsl:text>2</xsl:text>
                                    </xsl:attribute>
                                    <xsl:text>Total</xsl:text>
                                </td>
                                <td><xsl:value-of select="sum(//partido[votos_porciento>1]/votos_numero)"/></td>
                                <td><xsl:value-of select="sum(//partido[votos_porciento>1]/votos_porciento)"/></td>
                            </tr>
                        </table>
                    </div>
                </main>
                
                
            </body>
        </html>
        
    </xsl:template>
    
    
    
</xsl:stylesheet>