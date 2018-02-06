/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_SECTOR_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-sector-master/rns-sector-master.component';
import { RNS_SECTOR_MASTERService } from '../../../../../../main/webapp/app/entities/rns-sector-master/rns-sector-master.service';
import { RNS_SECTOR_MASTER } from '../../../../../../main/webapp/app/entities/rns-sector-master/rns-sector-master.model';

describe('Component Tests', () => {

    describe('RNS_SECTOR_MASTER Management Component', () => {
        let comp: RNS_SECTOR_MASTERComponent;
        let fixture: ComponentFixture<RNS_SECTOR_MASTERComponent>;
        let service: RNS_SECTOR_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_SECTOR_MASTERComponent],
                providers: [
                    RNS_SECTOR_MASTERService
                ]
            })
            .overrideTemplate(RNS_SECTOR_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_SECTOR_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_SECTOR_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_SECTOR_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_SECTOR_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
