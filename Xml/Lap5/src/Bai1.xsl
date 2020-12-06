<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Bai1.xsl
    Created on : August 22, 2020, 7:40 PM
    Author     : USER
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
                <title>Bai1.xsl</title>
            </head>
            <body>
                <table border="1" width="40%" style="margin:auto">
                    <h2  style="text-align:center">Danh sách nhân viên ở Việt nam</h2>
                    <tr>
                        <th style="text-align:center">Họ</th>
                        <th style="text-align:center">Tên</th>
                        <th style="text-align:center">Giới tính</th>
                        <th style="text-align:center">Ngày sinh</th>
                        <th style="text-align:center">Công ty</th>
                    </tr>
                    <xsl:for-each select="Employees/Employee">
                        <xsl:if test="Company[@country='Viet Nam']">
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="Name/LastName"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Name/FirstName"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Gender"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Birthday"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Company"/>
                        </td>
                    </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                <table border="1" width="40%" style="margin:auto">
                    <h2 style="text-align:center">Danh sách nhân viên ở nước ngoài</h2>
                    <tr>
                        <th style="text-align:center">Họ</th>
                        <th style="text-align:center">Tên</th>
                        <th style="text-align:center">Giới tính</th>
                        <th style="text-align:center">Ngày sinh</th>
                        <th style="text-align:center">Công ty</th>
                    </tr>
                    <xsl:for-each select="Employees/Employee">
                        <xsl:if test="Company[@country !='Viet Nam']">
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="Name/LastName"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Name/FirstName"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Gender"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Birthday"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Company"/>
                        </td>
                    </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                <table border="1" width="40%" style="margin:auto">
                    <h2 style="text-align:center">Danh sách nhân viên có năm sinh từ 1995 đến nay</h2>
                    <tr>
                        <th style="text-align:center">Họ</th>
                        <th style="text-align:center">Tên</th>
                        <th style="text-align:center">Giới tính</th>
                        <th style="text-align:center">Ngày sinh</th>
                        <th style="text-align:center">Công ty</th>
                    </tr>
                    <xsl:for-each select="Employees/Employee">
                        <xsl:if test="Birthday[@year >= 1995]">
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="Name/LastName"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Name/FirstName"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Gender"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Birthday"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Company"/>
                        </td>
                    </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                <table border="1" width="40%" style="margin:auto">
                    <h2 style="text-align:center">Danh sách công ty nước ngoài được đánh dấu </h2>
                    <tr>
                        <th style="text-align:center">Họ</th>
                        <th style="text-align:center">Tên</th>
                        <th style="text-align:center">Giới tính</th>
                        <th style="text-align:center">Ngày sinh</th>
                        <th style="text-align:center">Công ty</th>
                    </tr>
                    <xsl:for-each select="Employees/Employee">
                        
                    <tr>
                        <td style="text-align:center">
                        <xsl:value-of select="Name/LastName"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Name/FirstName"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Gender"/>
                        </td>
                        <td style="text-align:center">
                        <xsl:value-of select="Birthday"/>
                        </td>
                        <xsl:if test="Company[@country != 'Viet Nam']">
                        <td style="text-align:center; background-color:#ffb3d9">
                        <xsl:value-of select="Company"/>
                        </td>
                        </xsl:if>
                        <xsl:if test="Company[@country ='Viet Nam']">
                        <td style="text-align:center">
                        <xsl:value-of select="Company"/>
                        </td>
                        </xsl:if>
                    </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
