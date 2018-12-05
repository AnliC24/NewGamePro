var websocket;

//首先判断是否 支持 WebSocket
if('WebSocket' in window) {
    websocket = new WebSocket("ws://localhost:8080/GamePro/websocket");
} else if('MozWebSocket' in window) {
    websocket = new MozWebSocket("ws://localhost:8080/GamePro/websocket");
} else {
    websocket = new SockJS("http://localhost:8080/GamePro/sockjs/websocket");
}

// 打开时
websocket.onopen = function(evnt) {
    console.log("  websocket.onopen  ");
};


// 处理消息时
websocket.onmessage = function(evnt) {
    $("#msg").append("<p>(<font color='red'>" + evnt.data + "</font>)</p>");
    console.log("  websocket.onmessage   ");
};


websocket.onerror = function(evnt) {
    console.log("  websocket.onerror  ");
};

websocket.onclose = function(evnt) {
    console.log("  websocket.onclose  ");
};
$(function() {
 
    // 点击了发送消息按钮的响应事件
    $("#TXBTN").click(function(){
 
        // 获取消息内容
        var text = $("#tx").val();
 
        // 判断
        if(text == null || text == ""){
            alert(" content  can not empty!!");
            return false;
        }
 
        var msg = {
            msgContent: text,
            postsId: 1
        };
 
        // 发送消息
        websocket.send(JSON.stringify(msg));
        
        //发送完消息后，清楚文本框的值
        $("#tx").val('');
 
    });
 
 
});



demo = {
    initPickColor: function(){
        $('.pick-class-label').click(function(){
            var new_class = $(this).attr('new-class');
            var old_class = $('#display-buttons').attr('data-class');
            var display_div = $('#display-buttons');
            if(display_div.length) {
            var display_buttons = display_div.find('.btn');
            display_buttons.removeClass(old_class);
            display_buttons.addClass(new_class);
            display_div.attr('data-class', new_class);
            }
        });
    },

    initDocChart: function(){
      chartColor = "#FFFFFF";

      // General configuration for the charts with Line gradientStroke
      gradientChartOptionsConfiguration = {
          maintainAspectRatio: false,
          legend: {
              display: false
          },
          tooltips: {
            bodySpacing: 4,
            mode:"nearest",
            intersect: 0,
            position:"nearest",
            xPadding:10,
            yPadding:10,
            caretPadding:10
          },
          responsive: true,
          scales: {
              yAxes: [{
                display:0,
                gridLines:0,
                ticks: {
                    display: false
                },
                gridLines: {
                    zeroLineColor: "transparent",
                    drawTicks: false,
                    display: false,
                    drawBorder: false
                }
              }],
              xAxes: [{
                display:0,
                gridLines:0,
                ticks: {
                    display: false
                },
                gridLines: {
                  zeroLineColor: "transparent",
                  drawTicks: false,
                  display: false,
                  drawBorder: false
                }
              }]
          },
          layout:{
            padding:{left:0,right:0,top:15,bottom:15}
          }
      };

      

      myChart = new Chart(ctx, {
          type: 'line',
          responsive: true,
          data: {
              labels: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
              datasets: [{
                  label: "Active Users",
                  borderColor: "#f96332",
                  pointBorderColor: "#FFF",
                  pointBackgroundColor: "#f96332",
                  pointBorderWidth: 2,
                  pointHoverRadius: 4,
                  pointHoverBorderWidth: 1,
                  pointRadius: 4,
                  fill: true,
                  backgroundColor: gradientFill,
                  borderWidth: 2,
                  data: [542, 480, 430, 550, 530, 453, 380, 434, 568, 610, 700, 630]
              }]
          },
          options: gradientChartOptionsConfiguration
      });
    },

    initDashboardPageCharts: function(){

      chartColor = "#FFFFFF";

      // General configuration for the charts with Line gradientStroke
      gradientChartOptionsConfiguration = {
          maintainAspectRatio: false,
          legend: {
              display: false
          },
          tooltips: {
            bodySpacing: 4,
            mode:"nearest",
            intersect: 0,
            position:"nearest",
            xPadding:10,
            yPadding:10,
            caretPadding:10
          },
          responsive: 1,
          scales: {
              yAxes: [{
                display:0,
                gridLines:0,
                ticks: {
                    display: false
                },
                gridLines: {
                    zeroLineColor: "transparent",
                    drawTicks: false,
                    display: false,
                    drawBorder: false
                }
              }],
              xAxes: [{
                display:0,
                gridLines:0,
                ticks: {
                    display: false
                },
                gridLines: {
                  zeroLineColor: "transparent",
                  drawTicks: false,
                  display: false,
                  drawBorder: false
                }
              }]
          },
          layout:{
            padding:{left:0,right:0,top:15,bottom:15}
          }
      };

      gradientChartOptionsConfigurationWithNumbersAndGrid = {
          maintainAspectRatio: false,
          legend: {
              display: false
          },
          tooltips: {
            bodySpacing: 4,
            mode:"nearest",
            intersect: 0,
            position:"nearest",
            xPadding:10,
            yPadding:10,
            caretPadding:10
          },
          responsive: true,
          scales: {
              yAxes: [{
                gridLines:0,
                gridLines: {
                    zeroLineColor: "transparent",
                    drawBorder: false
                }
              }],
              xAxes: [{
                display:0,
                gridLines:0,
                ticks: {
                    display: false
                },
                gridLines: {
                  zeroLineColor: "transparent",
                  drawTicks: false,
                  display: false,
                  drawBorder: false
                }
              }]
          },
          layout:{
            padding:{left:0,right:0,top:15,bottom:15}
          }
      };

      var ctx = document.getElementById('bigDashboardChart').getContext("2d");

      var gradientStroke = ctx.createLinearGradient(500, 0, 100, 0);
      gradientStroke.addColorStop(0, '#80b6f4');
      gradientStroke.addColorStop(1, chartColor);

      var gradientFill = ctx.createLinearGradient(0, 200, 0, 50);
      gradientFill.addColorStop(0, "rgba(128, 182, 244, 0)");
      gradientFill.addColorStop(1, "rgba(255, 255, 255, 0.24)");

      var myChart = new Chart(ctx, {
          type: 'line',
          data: {
              labels: ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"],
              datasets: [{
                  label: "Data",
                  borderColor: chartColor,
                  pointBorderColor: chartColor,
                  pointBackgroundColor: "#1e3d60",
                  pointHoverBackgroundColor: "#1e3d60",
                  pointHoverBorderColor: chartColor,
                  pointBorderWidth: 1,
                  pointHoverRadius: 7,
                  pointHoverBorderWidth: 2,
                  pointRadius: 5,
                  fill: true,
                  backgroundColor: gradientFill,
                  borderWidth: 2,
                  data: [50, 150, 100, 190, 130, 90, 150, 160, 120, 140, 190, 95]
              }]
          },
          options: {
              layout: {
                  padding: {
                      left: 20,
                      right: 20,
                      top: 0,
                      bottom: 0
                  }
              },
              maintainAspectRatio: false,
              tooltips: {
                backgroundColor: '#fff',
                titleFontColor: '#333',
                bodyFontColor: '#666',
                bodySpacing: 4,
                xPadding: 12,
                mode: "nearest",
                intersect: 0,
                position: "nearest"
              },
              legend: {
                  position: "bottom",
                  fillStyle: "#FFF",
                  display: false
              },
              scales: {
                  yAxes: [{
                      ticks: {
                          fontColor: "rgba(255,255,255,0.4)",
                          fontStyle: "bold",
                          beginAtZero: true,
                          maxTicksLimit: 5,
                          padding: 10
                      },
                      gridLines: {
                          drawTicks: true,
                          drawBorder: false,
                          display: true,
                          color: "rgba(255,255,255,0.1)",
                          zeroLineColor: "transparent"
                      }

                  }],
                  xAxes: [{
                      gridLines: {
                          zeroLineColor: "transparent",
                          display: false,

                      },
                      ticks: {
                          padding: 10,
                          fontColor: "rgba(255,255,255,0.4)",
                          fontStyle: "bold"
                      }
                  }]
              }
          }
      });

      var cardStatsMiniLineColor = "#fff",
          cardStatsMiniDotColor = "#fff";

      ctx = document.getElementById('lineChartExample').getContext("2d");

      gradientStroke = ctx.createLinearGradient(500, 0, 100, 0);
      gradientStroke.addColorStop(0, '#80b6f4');
      gradientStroke.addColorStop(1, chartColor);

      gradientFill = ctx.createLinearGradient(0, 170, 0, 50);
      gradientFill.addColorStop(0, "rgba(128, 182, 244, 0)");
      gradientFill.addColorStop(1, "rgba(249, 99, 59, 0.40)");

      myChart = new Chart(ctx, {
          type: 'line',
          responsive: true,
          data: {
              labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
              datasets: [{
                  label: "Active Users",
                  borderColor: "#f96332",
                  pointBorderColor: "#FFF",
                  pointBackgroundColor: "#f96332",
                  pointBorderWidth: 2,
                  pointHoverRadius: 4,
                  pointHoverBorderWidth: 1,
                  pointRadius: 4,
                  fill: true,
                  backgroundColor: gradientFill,
                  borderWidth: 2,
                  data: [542, 480, 430, 550, 530, 453, 380, 434, 568, 610, 700, 630]
              }]
          },
          options: gradientChartOptionsConfiguration
      });


      ctx = document.getElementById('lineChartExampleWithNumbersAndGrid').getContext("2d");

      gradientStroke = ctx.createLinearGradient(500, 0, 100, 0);
      gradientStroke.addColorStop(0, '#18ce0f');
      gradientStroke.addColorStop(1, chartColor);

      gradientFill = ctx.createLinearGradient(0, 170, 0, 50);
      gradientFill.addColorStop(0, "rgba(128, 182, 244, 0)");
      gradientFill.addColorStop(1, hexToRGB('#18ce0f',0.4));
       
     
      
      myChart = new Chart(ctx, {
          type: 'line',
          responsive: true,
          data: {
              labels: ["12pm,", "3pm", "6pm", "9pm", "12am", "3am", "6am", "9am"],
              datasets: [{
                  label: "Email Stats",
                  borderColor: "#18ce0f",
                  pointBorderColor: "#FFF",
                  pointBackgroundColor: "#18ce0f",
                  pointBorderWidth: 2,
                  pointHoverRadius: 4,
                  pointHoverBorderWidth: 1,
                  pointRadius: 4,
                  fill: true,
                  backgroundColor: gradientFill,
                  borderWidth: 2,
                  data: [542, 480, 430, 550, 530, 453, 380, 434, 568, 610, 700, 630]
              }]
          },
          options: gradientChartOptionsConfigurationWithNumbersAndGrid
      });

      var e = document.getElementById("barChartSimpleGradientsNumbers").getContext("2d");

      gradientFill = ctx.createLinearGradient(0, 170, 0, 50);
      gradientFill.addColorStop(0, "rgba(128, 182, 244, 0)");
      gradientFill.addColorStop(1, hexToRGB('#2CA8FF', 0.6));

      var a =  {
        type : "bar",
        data : {
          labels : ["January","February","March","April","May","June","July","August","September","October","November","December"],
          datasets: [{
            label: "Active Countries",
            backgroundColor: gradientFill,
            borderColor: "#2CA8FF",
            pointBorderColor: "#FFF",
            pointBackgroundColor: "#2CA8FF",
            pointBorderWidth: 2,
            pointHoverRadius: 4,
            pointHoverBorderWidth: 1,
            pointRadius: 4,
            fill: true,
            borderWidth: 1,
            data: [80,99,86,96,123,85,100,75,88,90,123,155]
          }]
        },
        options: {
            maintainAspectRatio: false,
            legend: {
                display: false
            },
            tooltips: {
              bodySpacing: 4,
              mode:"nearest",
              intersect: 0,
              position:"nearest",
              xPadding:10,
              yPadding:10,
              caretPadding:10
            },
            responsive: 1,
            scales: {
                yAxes: [{
                  gridLines:0,
                  gridLines: {
                      zeroLineColor: "transparent",
                      drawBorder: false
                  }
                }],
                xAxes: [{
                  display:0,
                  gridLines:0,
                  ticks: {
                      display: false
                  },
                  gridLines: {
                    zeroLineColor: "transparent",
                    drawTicks: false,
                    display: false,
                    drawBorder: false
                  }
                }]
            },
            layout:{
              padding:{left:0,right:0,top:15,bottom:15}
            }
        }
      };

      var viewsChart = new Chart(e,a);
    },

    initGoogleMaps: function(){
        var myLatlng = new google.maps.LatLng(40.748817, -73.985428);
        var mapOptions = {
          zoom: 13,
          center: myLatlng,
          scrollwheel: false, //we disable de scroll over the map, it is a really annoing when you scroll through page
          styles: [{"featureType":"water","elementType":"geometry","stylers":[{"color":"#e9e9e9"},{"lightness":17}]},{"featureType":"landscape","elementType":"geometry","stylers":[{"color":"#f5f5f5"},{"lightness":20}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"color":"#ffffff"},{"lightness":17}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"color":"#ffffff"},{"lightness":29},{"weight":0.2}]},{"featureType":"road.arterial","elementType":"geometry","stylers":[{"color":"#ffffff"},{"lightness":18}]},{"featureType":"road.local","elementType":"geometry","stylers":[{"color":"#ffffff"},{"lightness":16}]},{"featureType":"poi","elementType":"geometry","stylers":[{"color":"#f5f5f5"},{"lightness":21}]},{"featureType":"poi.park","elementType":"geometry","stylers":[{"color":"#dedede"},{"lightness":21}]},{"elementType":"labels.text.stroke","stylers":[{"visibility":"on"},{"color":"#ffffff"},{"lightness":16}]},{"elementType":"labels.text.fill","stylers":[{"saturation":36},{"color":"#333333"},{"lightness":40}]},{"elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"featureType":"transit","elementType":"geometry","stylers":[{"color":"#f2f2f2"},{"lightness":19}]},{"featureType":"administrative","elementType":"geometry.fill","stylers":[{"color":"#fefefe"},{"lightness":20}]},{"featureType":"administrative","elementType":"geometry.stroke","stylers":[{"color":"#fefefe"},{"lightness":17},{"weight":1.2}]}]
        };

        var map = new google.maps.Map(document.getElementById("map"), mapOptions);

        var marker = new google.maps.Marker({
            position: myLatlng,
            title:"Hello World!"
        });
        // To add the marker to the map, call setMap();
        marker.setMap(map);
    },
	showNotification: function(formId,from, align){
    	color = 'primary';
    	
    	if(formId=='BigGmaePictureUpload')
    	{
    		if(align=='center')
            {   
            	var formData = new FormData($( "#"+formId)[0]);
            	var data=formData.get('file');	
            	if( data == "" )
            	{   
            		$.notify({
                    	icon: "now-ui-icons ui-1_bell-53",
                    	message: "无文件需要上传"
                    },{
                        type: color,
                        timer: 1500,
                        placement: {
                            from: from,
                            align: align
                        }
                    });
            	}
            	else
                {
            		//异步上传文件
                	$.ajax({
                		type:'POST',
                		url:'ajaxphotoUpload',
                		data:formData,
                		dataType: 'text',
                		cache: false,
                		processData: false,
                		contentType: false,
                		success: function(data){			
                				$.notify({
                                	icon: "now-ui-icons ui-1_bell-53",
                                	message: "文件上传成功"
                                },{
                                    type: color,
                                    timer: 1500,
                                    placement: {
                                        from: from,
                                        align: align
                                    }
                                });
                				var name=$('#gameName').value="";
                		}  
                	});
                }
            }
            //重置from表单内的div内容
            if(align=='left')
            {
               var formData = new FormData($( "#"+formId)[0]);
               var data=formData.get('file');
               if(data == "")
               {   
            	   $.notify({
                      	icon: "now-ui-icons ui-1_bell-53",
                      	message: "无需重复刷新"
                      },{
                          type: color,
                          timer: 1500,
                          placement: {
                              from: from,
                              align: align
                          }
                      });
               }
               else {
            	   var file=$('#file')[0];
            	   file.outerHTML = file.outerHTML;
            	   $.notify({
                     	icon: "now-ui-icons ui-1_bell-53",
                     	message: "文件路径刷新成功"
                     },{
                         type: color,
                         timer: 1500,
                         placement: {
                             from: from,
                             align: align
                         }
                     });
    		}
            }
            //搜索信息
            if(align=='right')
            {
            	$.notify({
                  	icon: "now-ui-icons ui-1_bell-53",
                  	message: "此功能尚未开发"
                  },{
                      type: color,
                      timer: 1500,
                      placement: {
                          from: from,
                          align: align
                      }
                  });
            }
    	} 
    	if(formId == 'SmallGmaePictureUpload')
        {
    		if(align == 'center')
    		{
    			var formData = new FormData($( "#"+formId)[0]);
            	var data=formData.get('Smallfile');	
            	if( data == "" )
            	{   
            		$.notify({
                    	icon: "now-ui-icons ui-1_bell-53",
                    	message: "无文件需要上传"
                    },{
                        type: color,
                        timer: 1500,
                        placement: {
                            from: from,
                            align: align
                        }
                    });
            	}
            	else
                {
            		//异步上传文件
                	$.ajax({
                		type:'POST',
                		url:'ajaxSmallTypePhotoUpload',
                		data:formData,
                		dataType: 'text',
                		cache: false,
                		processData: false,
                		contentType: false,
                		success: function(data){			
                				$.notify({
                                	icon: "now-ui-icons ui-1_bell-53",
                                	message: "文件上传成功"
                                },{
                                    type: color,
                                    timer: 1500,
                                    placement: {
                                        from: from,
                                        align: align
                                    }
                                });
                				var name=$('#smallName').val("");
                		}  
                	});
                }
    		}
    		//重置from表单内的div内容
            if(align=='left')
            {
               var formData = new FormData($( "#"+formId)[0]);
               var data=formData.get('Smallfile');
               if(data == "")
               {   
            	   $.notify({
                      	icon: "now-ui-icons ui-1_bell-53",
                      	message: "无需重复刷新"
                      },{
                          type: color,
                          timer: 1500,
                          placement: {
                              from: from,
                              align: align
                          }
                      });
               }
               else {
            	   var file=$('#Smallfile')[0];
            	   file.outerHTML = file.outerHTML;
            	   $.notify({
                     	icon: "now-ui-icons ui-1_bell-53",
                     	message: "文件路径刷新成功"
                     },{
                         type: color,
                         timer: 1500,
                         placement: {
                             from: from,
                             align: align
                         }
                     });
    		}
            }
          //搜索信息
            if(align=='right')
            {
            	$.notify({
                  	icon: "now-ui-icons ui-1_bell-53",
                  	message: "此功能尚未开发"
                  },{
                      type: color,
                      timer: 1000,
                      placement: {
                          from: from,
                          align: align
                      }
                  });
            }
        }
    	
    	if(formId == 'articleUpload')
        {
    		if(align == 'center')
    		{
    			var formData = new FormData($( "#"+formId)[0]);
            	var data=formData.get('upArticleInfo');	
            	if( data == "" )
            	{   
            		$.notify({
                    	icon: "now-ui-icons ui-1_bell-53",
                    	message: "文章内容不能为空"
                    },{
                        type: color,
                        timer: 1500,
                        placement: {
                            from: from,
                            align: align
                        }
                    });
            	}
            	else
                {   
            		
            		//异步上传文件
                	$.ajax({
                		type:'POST',
                		url:'articleUpload',
                		data:formData,
                		dataType: 'text',
                		cache: false,
                		processData: false,
                		contentType: false,
                		success: function(data){			
                				$.notify({
                                	icon: "now-ui-icons ui-1_bell-53",
                                	message: "文章上传成功"
                                },{
                                    type: color,
                                    timer: 1500,
                                    placement: {
                                        from: from,
                                        align: align
                                    }
                                });
                		}  
                	});
                }
    		}
    		if(align=='left')
            {
               var formData = new FormData($( "#"+formId)[0]);
               var data=formData.get('upArticleInfo');	
               if(data == "")
               {   
            	   $.notify({
                      	icon: "now-ui-icons ui-1_bell-53",
                      	message: "无需重复刷新"
                      },{
                          type: color,
                          timer: 1500,
                          placement: {
                              from: from,
                              align: align
                          }
                      });
               }
               else {
            	   $('#gameTitle').val('');
            	   $('#gameAuthor').val('');
            	  $('#upArticleInfo').val('');    
            	   $.notify({
                     	icon: "now-ui-icons ui-1_bell-53",
                     	message: "内容刷新成功"
                     },{
                         type: color,
                         timer: 1500,
                         placement: {
                             from: from,
                             align: align
                         }
                     });
    		}
            }
        	if(align=='right')
        	{
        		$.notify({
                  	icon: "now-ui-icons ui-1_bell-53",
                  	message: "此功能尚未开发"
                  },{
                      type: color,
                      timer: 1000,
                      placement: {
                          from: from,
                          align: align
                      }
                  });
        	}
        }
    	if(formId == 'ManagerDutyPublish')
    	{  
    		if(align=='center')
    	    {
    			var formData = new FormData($( "#"+formId)[0]);
            	var data=formData.get('dutyInfo');	
            	if(data == "")
            	{
            		$.notify({
                    	icon: "now-ui-icons ui-1_bell-53",
                    	message: "发布的内容不能为空"
                    },{
                        type: color,
                        timer: 1500,
                        placement: {
                            from: from,
                            align: align
                        }
                    });
            	}
            	else
            	{   
            		//异步发布任务
            		$.ajax({
                		type:'POST',
                		url:'ManagerDutyPublish',
                		data:formData,
                		cache: false,
                		processData: false,
                		contentType: false,
                		success: function(data){			
                				$.notify({
                                	icon: "now-ui-icons ui-1_bell-53",
                                	message: "任务发布成功"
                                },{
                                    type: color,
                                    timer: 1500,
                                    placement: {
                                        from: from,
                                        align: align
                                    }
                                });

                				//发布成功后，在聊天框那里显示出任务内容
                				 // 获取消息内容
                		        var text = $("#dutyInfo").val();
                		 
                		        var msg = {
                		            msgContent: "任务:"+text+"<br/>"+new Date(),
                		            postsId: 1
                		        };
                		        // 发送消息
                		        websocket.send(JSON.stringify(msg));
                		        
                		        //发送完消息后，清楚文本框的值
                		        $("#dutyInfo").val('');
                		}  
                	});
            	}
    	    }
    	}
    	
    }
        
};
