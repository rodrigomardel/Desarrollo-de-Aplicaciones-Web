<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">

    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
         <html>
            <body>
                <xsl:apply-templates select="//ciclo"/>
            </body>
        </html>

    </xsl:template>

    <xsl:template match="ciclo">
        <p>
            <xsl:value-of select="nombre"/>
        </p>
    </xsl:template>

</xsl:stylesheet>