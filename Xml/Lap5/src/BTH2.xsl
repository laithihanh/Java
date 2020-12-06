<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BTH2.xsl
    Created on : August 21, 2020, 2:34 PM
    Author     : ADMIN
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>BTH2.xsl</title>
            </head>
            <body>
                <xsl:for-each select="breakfast_menu/food">
                    <div style="background-color:teal;color:white;padding:4px;width:40%;margin:0 auto">
                        <span style="font-weight:bold">
                            <xsl:value-of select="name"/>
                        </span>-
                        <xsl:value-of select="price"/>
                    </div>
                    <div style="margin-left:20px;margin-bottom:1em;font-size:10pt;width:40%;margin:0 auto">
                        <p>
                        <xsl:value-of select="description"/>
                        <span style="font-style:italic"> (<xsl:value-of select="calories"/>
                       calories per serving)</span>
                        </p>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
