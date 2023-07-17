#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <malloc.h>
#include <string.h>


typedef struct
{
    char ma_sv[20];
    char ho_ten[50];
    char nganh_hoc[20];
    double diemTB;
    char que_quan[50];
} SinhVien;


typedef struct Node
{
    SinhVien sinh_vien;
    struct Node* next;
} Node;


typedef struct
{
    Node* dau;
    Node* cuoi;
} DSLK;

Node *node_LT;

DSLK* tao_danh_sach_lien_ket()
{
    DSLK *dslk = (DSLK*) malloc(sizeof(DSLK));

    dslk->dau = NULL;
    dslk->cuoi = NULL;

    return dslk;

}

Node* tao_node_moi(SinhVien sv)
{
    Node* node = (Node*)malloc(sizeof(Node));

    strcpy(node->sinh_vien.ma_sv,    sv.ma_sv);
    strcpy(node->sinh_vien.ho_ten,   sv.ho_ten);
    strcpy(node->sinh_vien.nganh_hoc,    sv.nganh_hoc);
    strcpy(node->sinh_vien.que_quan,    sv.que_quan);
    node->sinh_vien.diemTB =    sv.diemTB;

    node->next = NULL;

    return node;
}

void them_pt_dau_tien(DSLK* dslk, SinhVien sv)
{
    Node* node = tao_node_moi(sv);
    dslk->dau = node;
    dslk->cuoi= node;
}

void them_pt_vao_dau(DSLK* dslk,SinhVien sv)
{

    Node* node = tao_node_moi(sv);
    node-> next = dslk->dau;
    dslk-> dau = node;

}

void them_pt_vao_cuoi(DSLK* dslk,SinhVien sv)
{

    Node* node = tao_node_moi(sv);
    dslk->cuoi->next = node;
    dslk->cuoi = node;

}

void them_pt_vao_dslk(DSLK* dslk, SinhVien sv)
{
    if(dslk->dau == NULL)
    {
        them_pt_dau_tien(dslk,sv);
    }
    else
    {
        them_pt_vao_cuoi(dslk,sv);
        // them_pt_vao_dau(dslk,sv);
    }
}

Node* tim_kiem_sv (DSLK *dslk,char key[])
{
    Node * node = dslk->dau;
    while(node!=NULL)
    {
        if(strcmp(node->sinh_vien.ma_sv,key)==0)
        {
            return node;
        }
        node_LT = node;
        node = node->next;
    }
    return NULL;
}

void sua_thong_tin_sv(DSLK*dslk,char key[],double diemTB)
{
    Node *node_x = tim_kiem_sv(dslk,key);

    if(node_x!=NULL)
    {
        node_x->sinh_vien.diemTB = diemTB;
    }
    else
    {
        printf("khong tim thay sinh vien can sua : %s\n",key);

    }
}

// key : ma sinh vien can xoa
void xoa_sinh_vien (DSLK*dslk,char key[])
{
    Node *node_x = tim_kiem_sv(dslk,key);
    if(node_x != NULL)
    {
        if(node_x == dslk->dau)
        {
            dslk->dau = node_x->next;
            free(node_x);
            return;
        }
        node_LT->next=node_x->next;

        if(node_x == dslk->cuoi)
        {
            dslk->cuoi = node_LT;
        }

        free(node_x);
    }
    else
    {
        printf("Khong the xoa sinh vien : %s\n",key);
    }

}

void chen_sinh_vien (DSLK*dslk,char key[],SinhVien sv)
{
    Node *node_x = tim_kiem_sv(dslk,key);

    if(node_x!= NULL)
    {
        Node *node = tao_node_moi(sv);
        node->next = node_x->next;
        node_x->next=node;
    }
    else
    {
        them_pt_vao_cuoi(dslk,sv);
    }
}

void in_thong_tin_sv (SinhVien sv)
{
    printf("%s %s %s %.2lf %s \n",
           sv.ma_sv,sv.ho_ten,sv.nganh_hoc,sv.diemTB,sv.que_quan);
}

void hien_thi_toan_bo_ds (DSLK*dslk)
{
    Node *node = dslk->dau;

    while(node!= NULL)
    {
        in_thong_tin_sv(node->sinh_vien);
        node=node->next;
    }
}

void luu_file_van_ban(DSLK*dslk,char *file_path)
{
    FILE *file = fopen(file_path,"at");

    if(file!=NULL)
    {
        Node *node = dslk->dau;
        while(node!= NULL)
        {
            fprintf(file,"%s %s %s %.2lf %s \n",
                    node->sinh_vien.ma_sv, node->sinh_vien.ho_ten, node->sinh_vien.nganh_hoc, node->sinh_vien.diemTB, node->sinh_vien.que_quan);

            node = node->next;
        }
        printf("Ghi File thanh cong !!!\n");
    }
    else
    {
        printf("Khong the mo file !!!\n");
    }

    fclose(file);

}

void in_menu()
{
    printf("\n\n========= MOI LUA CHON CHUC NANG =========\n\n");
    printf("1. Them sinh vien vao DSLK \n");
    printf("2. Tim kiem 1 sinh vien trong DSLK \n");
    printf("3. Sua thong tin 1 sinh vien trong DSLK \n");
    printf("4. Xoa 1 sinh vien khoi DSLK \n");
    printf("5. Chen 1 sinh vien vao DSLK \n");
    printf("6. In toan bo danh sach sinh vien \n");
    printf("7. Luu danh sach sinh vien vao file \n");
    printf("0. Ket thuc chuong trinh \n");
    printf("Nhap vao lua chon cua ban:    ");
}
int main()
{
    char *file_path = "C:\\INPUT LAP TRINH C\\file_van_ban.txt";

    DSLK *dslk = tao_danh_sach_lien_ket();
    SinhVien sv;

    char ma_sv[20];

    int lua_chon;

    do
    {
        in_menu();
        scanf("%d",&lua_chon);

        switch(lua_chon)
        {
        case 1:
            printf("\n\n");
            // nhap thong tin sinh vien
            fflush(stdin);
            printf("- Nhap ma sv : ");
            gets(sv.ma_sv);
            printf("- Nhap ho ten sv : ");
            gets(sv.ho_ten);
            printf("- Nhap nganh hoc : ");
            gets(sv.nganh_hoc);
            printf("- Nhap que quan sv : ");
            gets(sv.que_quan);
            printf("- Nhap diem TB : ");
            scanf("%lf",&sv.diemTB);

            them_pt_vao_dslk(dslk,sv);

            printf("\n\n");
            break;

        case 2:
            printf("\n\n");
            printf("- Nhap ma sv : ");

            scanf("%s",ma_sv);

            Node *node = tim_kiem_sv(dslk,ma_sv);
            if(node!= NULL)
            {
                in_thong_tin_sv(node->sinh_vien);
            }
            else
            {
                printf("khong tim thay sinh vien: %s\n",ma_sv);
            }

            printf("\n\n");
            break;

        case 3:
            printf("\n\n");
            printf("- Nhap ma sv can sua: ");

            gets(ma_sv);

            printf("- Nhap diem trung binh moi : ");
            double diemTB;
            scanf("%lf",&diemTB);

            sua_thong_tin_sv(dslk,ma_sv ,diemTB);

            printf("\n\n");
            break;
        case 4:
            printf("\n\n");
            printf("- Nhap ma sv can xoa: ");

            gets(ma_sv);

            xoa_sinh_vien(dslk,ma_sv);\

            printf("\n\n");
            break;
        case 5:
            printf("\n\n");
            printf("- Nhap ma sv lien truoc: ");
            char key[20];
            gets(key);

            SinhVien sv;

            printf("- Nhap ma sv : ");
            gets(sv.ma_sv);
            printf("- Nhap ho ten sv : ");
            gets(sv.ho_ten);
            printf("- Nhap nganh hoc : ");
            gets(sv.nganh_hoc);
            printf("- Nhap que quan sv : ");
            gets(sv.que_quan);
            printf("- Nhap diem TB : ");
            scanf("%lf",&sv.diemTB);

            chen_sinh_vien(dslk,key,sv);

            printf("\n\n");
            break;
        case 6:
            printf("\n\n");
            hien_thi_toan_bo_ds(dslk);
            printf("\n\n");
            break;
        case 7:
            printf("\n\n");
            luu_file_van_ban(dslk,file_path);
            printf("\n\n");
            break;
        default:
            break;
        }

    }
    while(lua_chon!=0);

    return 0;
}

