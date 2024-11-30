<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="3.0">

    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <style>
                    .orange{color:orange}
                    .blue{color:blue}
                    .green{color:green}
                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="AAA">
        <div class="orange">
            <p>
                <xsl:text>Nombre</xsl:text>
                <xsl:value-of select="name()"/>
                <br/>
                <xsl:text>Identificador:</xsl:text>
                <xsl:value-of select="@id"/>
                <xsl:apply-templates/>
            </p>
        </div>       
    </xsl:template>
     <xsl:template match="BBB">
        <div class="blue">
            <p>
                <xsl:text>Nombre</xsl:text>
                <xsl:value-of select="name()"/>
                <br/>
                <xsl:text>Identificador:</xsl:text>
                <xsl:value-of select="@id"/>
                <xsl:apply-templates/>
            </p>
        </div>       
    </xsl:template>
     <xsl:template match="CCC">
        <div class="green">
            <p>
                <xsl:text>Nombre</xsl:text>
                <xsl:value-of select="name()"/>
                <br/>
                <xsl:text>Identificador:</xsl:text>
                <xsl:value-of select="@id"/>
                <xsl:apply-templates/>
            </p>   
        </div>           
    </xsl:template>
</xsl:stylesheet>