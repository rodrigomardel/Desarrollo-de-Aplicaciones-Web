<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="/">
        <html>
            <body>
                <h1><xsl:value-of select="cifp/@nombre"/></h1>
                <p>
                    <xsl:text>Pagina web:</xsl:text>
                    <a>
                        <xsl:attribute name="href">
                            <xsl:value-of select="cifp/@web"/>
                        </xsl:attribute>      
                        <xsl:value-of select="cifp/@web"/>    
                    </a>
                </p>
                <table border="1">
                    <tr>
                        <th>Nombre del ciclo</th>
                        <th>Grado</th>
                        <th>Año del título</th>
                    </tr>
                    <xsl:apply-templates select="//ciclos"/>              
                </table>
            </body>
        </html>      
    </xsl:template>
    
    <xsl:template match="ciclo">        
        <tr>
            <td><xsl:value-of select="nombre"/> </td>          
            <td><xsl:value-of select="grado"/> </td>               
            <td><xsl:value-of select="decretoTitulo/@año"/> </td>               
        </tr>        
    </xsl:template>
    
</xsl:stylesheet>