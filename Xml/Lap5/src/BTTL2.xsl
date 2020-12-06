<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BTTL2.xsl
    Created on : August 21, 2020, 3:16 PM
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
                <title>BTTL2.xsl</title>
            </head>
            <body>
                <table border="1" width="40%" style="margin:auto">
                    <tr bgcolor="#4d94ff">
                        <th style="text-align:center">Stastion NAme</th>
                        <th style="text-align:center">Post code</th>
                        <th style="text-align:center">Line</th>
                    </tr>
                    <xsl:for-each select="content/cd">
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="name"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="code"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="line"/>
                        </td>
                    </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
