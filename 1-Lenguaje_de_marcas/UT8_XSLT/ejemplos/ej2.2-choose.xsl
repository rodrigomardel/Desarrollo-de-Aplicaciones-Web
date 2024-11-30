<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="/">
        <html>
            <style>
                .verde{color:green;}
            </style>
            <body>
                <h1 class="verde">Mundiales</h1>
                <a>
                    <xsl:attribute name="href" select="//web"/>
                    <xsl:text>Nuestra Web</xsl:text>
                </a>
                <ul>
                    <xsl:apply-templates select="//pilotos/piloto"/>
                </ul>  
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="//pilotos/piloto">
        
        <li>
            <xsl:if test="nacionalidad='Española'">
                <xsl:attribute name="class">verde</xsl:attribute>
            </xsl:if>
            <xsl:text>Nombre:</xsl:text>
            <xsl:value-of select="nombre"/>
            <xsl:text> - ID:</xsl:text>
            <xsl:value-of select="@pilotoId"/>
            <xsl:choose>
                <xsl:when test="nacionalidad='Española'">
                    <xsl:text>¡Española!</xsl:text>
                </xsl:when>
                <xsl:when test="nacionalidad='Británica'">
                    <xsl:text>¡Británico!</xsl:text>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:text>Otro</xsl:text>
                </xsl:otherwise>
            </xsl:choose>
        </li>              
        
    </xsl:template>
    
    
</xsl:stylesheet>