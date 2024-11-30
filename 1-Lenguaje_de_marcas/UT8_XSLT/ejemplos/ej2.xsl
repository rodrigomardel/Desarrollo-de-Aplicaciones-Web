<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">

    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
        <html>
            <body>
                <h1>Mundiales</h1>
                <xsl:apply-templates select="//pilotos/piloto[nacionalidad='Española']"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="//pilotos/piloto">
        <p>
            <xsl:text>Nombre:</xsl:text>
            <xsl:value-of select="nombre"/>
            <xsl:text> - ID:</xsl:text>
            <xsl:value-of select="@pilotoId"/>
        </p>
    </xsl:template>
    

</xsl:stylesheet>