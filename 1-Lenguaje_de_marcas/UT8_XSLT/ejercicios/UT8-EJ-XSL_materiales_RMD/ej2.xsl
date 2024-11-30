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
                    body{background-color:aqua;}
                </style>
            </head>
            <body>
                <h1><xsl:text>Lista de albumes</xsl:text></h1>    
                
                <xsl:for-each select="//cd">   
                    <h2>
                        <xsl:value-of select="nombreInterprete"/>
                        <xsl:text>-</xsl:text>
                        <xsl:value-of select="tituloAlbum"/>
                        <!-- <xsl:value-of select="concat(nombreInterprete, '-', tituloAlbum)"/> (Lo mismo con «concat») --> 
                    </h2>
                    <table border="1">
                        <xsl:choose>
                            <xsl:when test="position()=1">
                                <xsl:attribute name="class">
                                    <xsl:text>verde</xsl:text>
                                </xsl:attribute>
                            </xsl:when>
                            <xsl:when test="position()=2">
                                <xsl:attribute name="class">
                                    <xsl:text>amarillo</xsl:text>
                                </xsl:attribute>
                            </xsl:when>
                            <!-- Ejemplo «otra opción» -->
                            <xsl:otherwise>
                                <xsl:attribute name="class">
                                    <xsl:text>azul</xsl:text>
                                </xsl:attribute>
                            </xsl:otherwise>
                        </xsl:choose>
                        <tr>
                            <th><xsl:text>Pista</xsl:text></th>          
                            <th><xsl:text>Título</xsl:text></th>               
                            <th><xsl:text>Duración</xsl:text></th>               
                        </tr>                                
                        <xsl:for-each select="pista">
                            <tr>
                                <td><xsl:value-of select="num"/></td>          
                                <td><xsl:value-of select="titulo"/></td>               
                                <td><xsl:value-of select="duracion"/></td>               
                            </tr>                          
                        </xsl:for-each>  
                    </table>                     
                </xsl:for-each>
                
                
            </body>
        </html>
    </xsl:template>
    
    
    
</xsl:stylesheet>