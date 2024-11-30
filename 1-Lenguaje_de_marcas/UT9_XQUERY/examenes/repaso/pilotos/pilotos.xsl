<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    
    <xsl:template match="/">
        <html>
            <style>
                .rojo{color:red;}
                .azul{color:blue;}
            </style>
            <body>        
                <xsl:for-each select="//vuelo[ruta/substring(fecha_salida,4,2)='06']">
                    <h1>
                        <xsl:choose>
                            <xsl:when test="position() mod 2=1">
                                <xsl:attribute name="class">
                                    <xsl:text>azul</xsl:text>
                                </xsl:attribute>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:attribute name="class">
                                    <xsl:text>rojo</xsl:text>
                                </xsl:attribute>
                            </xsl:otherwise>
                        </xsl:choose>
                        <xsl:value-of select="numero"/>
                    </h1> 
                    <h1><xsl:value-of select="avion"/></h1>
                    <table>
                        <xsl:attribute name="border">
                            <xsl:text>1</xsl:text>
                        </xsl:attribute>
                        <xsl:for-each select="ruta/*">
                            <tr>
                                <td><xsl:value-of select="./name()"/></td>
                                <td><xsl:value-of select="."/></td>
                            </tr>    
                        </xsl:for-each>
                    </table>
                </xsl:for-each>              
            </body>
        </html>        
    </xsl:template>  
</xsl:stylesheet>