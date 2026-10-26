import 'package:flutter/material.dart';

class TrangChNh extends StatelessWidget {
  const TrangChNh({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFFDF4E1),
      body: SafeArea(
        child: SizedBox.expand(
          child: Stack(
            clipBehavior: Clip.none,
            children: [
              // Nút góc trên bên trái
              Positioned(
                left: 32,
                top: 46,
                child: Container(
                  clipBehavior: Clip.antiAlias,
                  decoration: ShapeDecoration(
                    color: const Color(0xFF38132B),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(16),
                    ),
                    shadows: const [
                      BoxShadow(
                        color: Color(0x4C000000),
                        blurRadius: 3,
                        offset: Offset(0, 1),
                        spreadRadius: 0,
                      ), // Đã thêm dấu phẩy bị thiếu ở đây
                      BoxShadow(
                        color: Color(0x26000000),
                        blurRadius: 8,
                        offset: Offset(0, 4),
                        spreadRadius: 3,
                      ),
                    ],
                  ),
                  child: Row(
                    mainAxisSize: MainAxisSize.min,
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Container(
                        height: 56,
                        padding: const EdgeInsets.all(16),
                        decoration: ShapeDecoration(
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(16),
                          ),
                        ),
                        child: Row(
                          mainAxisSize: MainAxisSize.min,
                          mainAxisAlignment: MainAxisAlignment.center,
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: [
                            SizedBox(
                              width: 24,
                              height: 24,
                              child: Stack(
                                children: const [
                                  Icon(
                                    Icons.yard_rounded,
                                    color: Color(0xFFFDF4E1),
                                    size: 24,
                                  ),
                                ],
                              ),
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                ),
              ),

              // Thông tin cá nhân (Ảnh đại diện, Tên, MSSV/ID)
              Positioned(
                left: 32,
                top: 286,
                child: SizedBox(
                  width: 326,
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    mainAxisAlignment: MainAxisAlignment.start,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      // Ảnh đại diện
                      Container(
                        width: 150,
                        height: 201,
                        decoration: ShapeDecoration(
                          image: const DecorationImage(
                            image: AssetImage("assets/avt.png"),
                            fit: BoxFit.cover,
                          ),
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(100),
                          ),
                        ),
                      ),
                      const SizedBox(height: 8),

                      // Tên
                      const SizedBox(
                        width: 326,
                        child: Text(
                          'Nguyễn Vũ Hoàng',
                          textAlign: TextAlign.center,
                          style: TextStyle(
                            color: Color(0xFF38132B),
                            fontSize: 26,
                            fontStyle: FontStyle.italic,
                            fontFamily: 'Times New Roman',
                            fontWeight: FontWeight.w700,
                            height: 1.25,
                          ),
                        ),
                      ),
                      const SizedBox(height: 8),

                      // Mã định danh / MSSV
                      const Text(
                        '052206004253',
                        style: TextStyle(
                          color: Color(0xFF38132B),
                          fontSize: 14,
                          fontFamily: 'Times New Roman',
                          fontWeight: FontWeight.w400,
                          height: 1.50,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}