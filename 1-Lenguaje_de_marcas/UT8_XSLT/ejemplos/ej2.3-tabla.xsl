<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="/">
        <html>
            <body>
                <h1> Mundiales </h1>
                <a>
                    <xsl:attribute name="href">
                        <xsl:value-of select="//web"/>
                    </xsl:attribute>
                    <xsl:text>Web de los mundiales:</xsl:text>
                </a>
                <table border="1">
                    <tr>
                        <th>Nombre</th>
                        <th>Nacionalidad</th>
                        <th>Equipo</th>
                        <th>Número de titulos</th>
                        <th>Año de los titulos</th>
                    </tr>
                    <xsl:for-each select="//pilotos/piloto">
                    <xsl:sort select="nombre" order="descending"/>
                        <tr>
                            <td><xsl:value-of select="nombre"/></td>
                            <td><xsl:value-of select="nacionalidad"/></td>
                            <td><xsl:value-of select="equipo"/></td>
                            <td><xsl:value-of select="count(titulos/titulo)"/></td>
                            <td>
                                <ul>
                                    <xsl:for-each select="titulos/titulo[.&lt;2015]">
                                        <li><xsl:value-of select="."/></li>   
                                    </xsl:for-each>
                                </ul>
                            </td>
                        </tr>
                    </xsl:for-each>               
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>